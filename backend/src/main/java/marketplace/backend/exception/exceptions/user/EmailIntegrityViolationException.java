package marketplace.backend.exception.exceptions.user;

public class EmailIntegrityViolationException extends RuntimeException {
    
    private String email;

    public EmailIntegrityViolationException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
