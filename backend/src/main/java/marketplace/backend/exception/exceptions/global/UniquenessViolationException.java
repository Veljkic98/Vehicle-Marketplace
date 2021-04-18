package marketplace.backend.exception.exceptions.global;

public class UniquenessViolationException extends RuntimeException {

    private String message;

    public UniquenessViolationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    
}
