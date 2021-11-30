import java.net.URL;

public class CodeEditor {

    private String name;
    private URL repository;
    private String[] developers;

    public CodeEditor(String name,  URL repository, String... developers) {
        this.name = name;
        this.repository = repository;
        this.developers = developers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getRepository() {
        return repository;
    }

    public void setRepository(URL repository) {
        this.repository = repository;
    }

    public String[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(String[] developers) {
        this.developers = developers;
    }

}