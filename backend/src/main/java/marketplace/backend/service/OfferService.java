package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.offer.OfferPossessionException;
import marketplace.backend.model.AuthenticatedUser;
import marketplace.backend.model.File;
import marketplace.backend.model.Offer;
import marketplace.backend.model.User;
import marketplace.backend.repository.AuthenticatedUserRepository;
import marketplace.backend.repository.OfferRepository;

@Service
public class OfferService implements MyService<Offer> {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private FileServiceImpl fileService;

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

        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        entity.setAuthenticatedUser(user);

        return offerRepository.save(entity);
    }

    @Override
    public Offer update(Offer entity) {

        return null;
    }

    @Override
    public void deleteById(Long id) {

        Offer offer;

        if ((offer = offerRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Offer", id);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // auth user can delete only his offers
        if (user instanceof AuthenticatedUser)
            if (user.getId() != offer.getAuthenticatedUser().getId())
                throw new OfferPossessionException(offer.getId());

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

        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        entity.setAuthenticatedUser(user);

        return offerRepository.save(entity);
    }

    public Offer update(Offer entity, MultipartFile file) {

        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        entity.setAuthenticatedUser(user);

        Offer offer;

        // check if entity exists
        if ((offer = offerRepository.findById(entity.getId()).orElse(null)) == null)
            throw new MyEntityNotFoundException("Offer", entity.getId());

        // check if offer is in possession of user
        if (offer.getAuthenticatedUser().getId() != entity.getAuthenticatedUser().getId())
            throw new OfferPossessionException(entity.getId());

        Long oldImageId;

        try {
            oldImageId = offer.getImages().getId();
        } catch (NullPointerException e) {
            oldImageId = null;
        }

        if (!file.isEmpty()) 
            entity.setImages(fileService.add(file));

        offer = offerRepository.save(entity);

        // delete old image
        if (oldImageId != null)
            fileService.remove(oldImageId);

        return offer;
    }

}
