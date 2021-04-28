package marketplace.backend.exception.exceptions.global;

/**
 * Exception should be thrown when trying to
 * add entity which disturb uniqueness of another one
 * 
 * @author Veljko
 */
public class UniquenessViolationException extends RuntimeException {

    private String message;

    /**
     * Class contructor.
     * 
     * @param message is exception (response) message 
     */
    public UniquenessViolationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    
}
