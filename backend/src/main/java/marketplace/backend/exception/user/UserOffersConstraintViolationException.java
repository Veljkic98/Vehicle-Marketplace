package marketplace.backend.exception.user;

public class UserOffersConstraintViolationException extends RuntimeException {
    
    private Long id;

    public UserOffersConstraintViolationException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

}
