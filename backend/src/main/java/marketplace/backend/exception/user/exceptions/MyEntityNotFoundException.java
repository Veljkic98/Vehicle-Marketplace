package marketplace.backend.exception.user.exceptions;

public class MyEntityNotFoundException extends RuntimeException {
    
    private Long id;

    public MyEntityNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
