package net.pryoscode.kanai.code;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
@Slf4j
@UtilityClass
public class Instance {

    private static final List<Object> OBJECTS = new ArrayList<>();

    @SneakyThrows
    public static <T> T get(@NonNull Class<T> clazz) {
        for (val object : OBJECTS)
            if (clazz.isInstance(object))
                return (T) object;

        if (!clazz.isAnnotationPresent(Singleton.class))
            throw new SingletonException();

        for (val constructor : clazz.getDeclaredConstructors())
            if (constructor.canAccess(null))
                throw new SingletonException();

        log.info("new " + clazz.getCanonicalName());
        val constructor = clazz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        val object = constructor.newInstance();
        OBJECTS.add(object);
        return (T) object;
    }

}