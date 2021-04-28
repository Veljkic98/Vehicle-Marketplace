package marketplace.backend.exception.exceptions.user;

/**
 * Exception should be thrown when trying to add or 
 * update user with email or company name whose are 
 * taken by another user.
 * 
 * @author Veljko
 */
public class EmailOrCompanyNameIntegrityViolationException extends RuntimeException {
    
    private String email;

    private String companyName;

    /**
     * Class constructor.
     * 
     * @param email         of user
     * @param companyName   of user
     */
    public EmailOrCompanyNameIntegrityViolationException(String email, String companyName) {
        this.email = email;
        this.companyName = companyName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCompanyName() {
        return this.companyName;
    }

}
