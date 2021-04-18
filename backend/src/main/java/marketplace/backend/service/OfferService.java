package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.model.Offer;
import marketplace.backend.repository.OfferRepository;

@Service
public class OfferService implements MyService<Offer> {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer findById(Long id) {

        Offer offer;

        if ((offer = offerRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Offer", id);

        return offer;
    }

    @Override
    public Offer add(Offer entity) {

        return offerRepository.save(entity);
    }

    @Override
    public Offer update(Offer entity) {

        if (offerRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Offer", entity.getId());

        return offerRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {

        if (offerRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Offer", id);

        offerRepository.deleteById(id);
    }

}
