package marketplace.backend.exception.user;

public class EmailOrCompanyNameIntegrityViolationException extends RuntimeException {
    
    private String email;

    private String companyName;

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
