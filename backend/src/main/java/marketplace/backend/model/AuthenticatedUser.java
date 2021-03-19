package marketplace.backend.model;

import java.util.List;

public class AuthenticatedUser extends User {

    private String companyName;
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
