package marketplace.backend.exception.user;

public class UserNotFoundException extends RuntimeException {
    
    private Long userId;

    public UserNotFoundException(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

}
