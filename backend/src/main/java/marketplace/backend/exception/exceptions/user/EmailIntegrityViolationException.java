package marketplace.backend.exception.exceptions.user;

/**
 * Exception should be thrown when trying to
 * add user with email which is taken by another user,
 * or trying to update users email, which is taken
 * by another user too.
 * 
 * @author Veljko
 */
public class EmailIntegrityViolationException extends RuntimeException {
    
    private String email;

    /**
     * Class constructor.
     * 
     * @param email of user
     */
    public EmailIntegrityViolationException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
