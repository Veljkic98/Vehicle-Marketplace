package marketplace.backend.exception.exceptions.user;

public class UserNotFoundException extends RuntimeException {
    
    private Long userId;

    public UserNotFoundException(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

}
