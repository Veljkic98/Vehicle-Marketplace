package marketplace.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authenticated_user")
public class AuthenticatedUser extends User {

    /**
     * Company name is marketplace name or users username
     */
    @Column(name = "company_name", nullable = true, unique = true)
    private String companyName;

    @OneToMany(mappedBy = "authenticatedUser")
    private List<Offer> offers;

    public AuthenticatedUser() {
        super();
    }

    public AuthenticatedUser(String fisrtName, String lastName, String email, String password,
            String companyName, List<Offer> offers) {
        super(fisrtName, lastName, email, password);
        this.companyName = companyName;
        this.offers = offers;
    }

    public AuthenticatedUser(Long id, String fisrtName, String lastName, String email, String password,
            String companyName, List<Offer> offers) {
        super(id, fisrtName, lastName, email, password);
        this.companyName = companyName;
        this.offers = offers;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", fisrtName='" + getFisrtName() + "'" + ", lastName='" + getLastName()
                + "'" + ", email='" + getEmail() + "'" + ", password='" + getPassword() + "'" + ", companyName='"
                + getCompanyName() + "'" + "}";
    }

}
