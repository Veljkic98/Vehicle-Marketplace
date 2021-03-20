package marketplace.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(Long id, String fisrtName, String lastName, String email, String password) {
        super(id, fisrtName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fisrtName='" + getFisrtName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}
