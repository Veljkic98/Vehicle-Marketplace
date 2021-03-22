package marketplace.backend.service;

import marketplace.backend.model.Offer;

public interface OfferService {
    
    public Offer findById(Long id);

    public Offer add(Offer admin);

    public Offer update(Offer admin);

    public void deleteById(Long id);
}
