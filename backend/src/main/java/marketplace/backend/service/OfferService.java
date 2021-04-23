package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.model.File;
import marketplace.backend.model.Offer;
import marketplace.backend.repository.AuthenticatedUserRepository;
import marketplace.backend.repository.OfferRepository;

@Service
public class OfferService implements MyService<Offer> {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private AuthenticatedUserRepository authenticatedUserRepository;

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

    public Page<Offer> findAll(Pageable pageable) {

        Page<Offer> page = offerRepository.findAll(pageable);

        return page;
    }

    public Page<Offer> findAllByUser(Pageable pageable, Long userId) {

        if (authenticatedUserRepository.findById(userId).orElse(null) == null) 
            throw new MyEntityNotFoundException("User", userId);

        Page<Offer> page = offerRepository.findByAuthenticatedUserId(userId, pageable);

        return page;
    }

    public Offer add(Offer entity, MultipartFile file) {

        File image;
        image = fileService.add(file);

        entity.setImages(image);

        return offerRepository.save(entity);
    }

}
