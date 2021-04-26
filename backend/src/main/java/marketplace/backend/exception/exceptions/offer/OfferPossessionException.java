package marketplace.backend.exception.exceptions.offer;

public class OfferPossessionException extends RuntimeException {

    private Long id;

    public OfferPossessionException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
}
