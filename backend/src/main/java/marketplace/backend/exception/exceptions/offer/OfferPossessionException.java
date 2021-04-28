package marketplace.backend.exception.exceptions.offer;

/**
 * Exception should be thrown when user try
 * to get offer which belongs to another user.
 * 
 * @author Veljko
 */
public class OfferPossessionException extends RuntimeException {

    private Long id;

    public OfferPossessionException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
}
