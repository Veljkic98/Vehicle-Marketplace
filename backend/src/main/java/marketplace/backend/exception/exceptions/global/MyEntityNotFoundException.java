package marketplace.backend.exception.exceptions.global;

public class MyEntityNotFoundException extends RuntimeException {

    private String message;

    public MyEntityNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    
}
