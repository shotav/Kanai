package net.pryoscode.kanai.boilerplate;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class Instance {

    private static final List<Object> OBJECTS = new ArrayList<>();

    @SneakyThrows
    public static <T> T get(@NonNull Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Singleton.class))
            throw new Exception();

        for (val object : OBJECTS)
            if (clazz.isInstance(object))
                return (T) object;

        val constructor = clazz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        val object = constructor.newInstance();
        OBJECTS.add(object);
        return (T) object;
    }

}