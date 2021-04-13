package marketplace.backend.exception.exceptions.user;

public class MyEntityNotFoundException extends RuntimeException {
    
    private Long id;

    public MyEntityNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
