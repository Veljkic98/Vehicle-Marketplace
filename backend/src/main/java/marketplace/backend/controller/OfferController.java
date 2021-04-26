package marketplace.backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import marketplace.backend.dto.requestDTO.OfferRequestDTO;
import marketplace.backend.mapper.OfferMapper;
import marketplace.backend.model.AuthenticatedUser;
import marketplace.backend.model.Offer;
import marketplace.backend.service.OfferService;

@RestController
@RequestMapping(path = "/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferMapper mapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Offer offer = offerService.findById(id);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.OK);
    }

    @GetMapping(path = "/by-page")
    public ResponseEntity<?> findAll(Pageable pageable) {

        Page<Offer> offers = offerService.findAll(pageable);

        return new ResponseEntity<>(mapper.toDtoPage(offers), HttpStatus.OK);
    }

    @GetMapping(path = "/by-page/{userId}")
    public ResponseEntity<?> findAll(Pageable pageable, @PathVariable Long userId) {

        Page<Offer> offers = offerService.findAllByUser(pageable, userId);

        return new ResponseEntity<>(mapper.toDtoPage(offers), HttpStatus.OK);
    }

    @GetMapping(path = "/by-page/my")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> findAllMy(Pageable pageable) {

        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Page<Offer> offers = offerService.findAllByUser(pageable, user.getId());

        return new ResponseEntity<>(mapper.toDtoPage(offers), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> add(@RequestPart("file") MultipartFile file,
            @Valid @RequestPart("dto") OfferRequestDTO dto) {

        Offer offer = offerService.add(mapper.toEntity(dto), file);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestPart("file") MultipartFile file,
            @Valid @RequestPart("dto") OfferRequestDTO dto) {

        Offer offer = mapper.toEntity(dto);

        offer.setId(id);

        offer = offerService.update(offer, file);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        offerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
