package marketplace.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "make")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // @OneToOne
    // private Model model;

    public Make() {
    }

    public Make(String name) {
        this.name = name;
        // this.model = model;
    }

    public Make(Long id, String name) {
        this.id = id;
        this.name = name;
        // this.model = model;
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

    // public Model getModel() {
    //     return this.model;
    // }

    // public void setModel(Model model) {
    //     this.model = model;
    // }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + "}";
    }

}
