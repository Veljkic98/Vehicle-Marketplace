package marketplace.backend.exception.user;

public class MyEntityNotFoundException extends RuntimeException {
    
    private Long userId;

    public MyEntityNotFoundException(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }
}
