package marketplace.backend.model;

public class Make {

    private Long id;
    private String name;
    private Model model;

    public Make() {
    }

    public Make(String name, Model model) {
        this.name = name;
        this.model = model;
    }

    public Make(Long id, String name, Model model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", model='" + getModel() + "'" + "}";
    }

}
