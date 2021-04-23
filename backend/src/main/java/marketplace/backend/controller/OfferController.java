package marketplace.backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return new ResponseEntity<>(mapper.toDtoPage(offers) , HttpStatus.OK);
    }

    @GetMapping(path = "/by-page/{userId}")
    public ResponseEntity<?> findAll(Pageable pageable, @PathVariable Long userId) {

        Page<Offer> offers = offerService.findAllByUser(pageable, userId);

        return new ResponseEntity<>(mapper.toDtoPage(offers), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody OfferRequestDTO dto) {

        Offer offer = offerService.add(mapper.toEntity(dto));

        // TODO: Umesto ovoga prebaciti da se cita ko je ulogovan i njega postaviti.
        AuthenticatedUser user = new AuthenticatedUser();
        user.setId(1L);

        offer.setAuthenticatedUser(user);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OfferRequestDTO dto) {

        Offer offer = mapper.toEntity(dto);
        offer.setId(id);

        // TODO: Umesto ovoga prebaciti da se cita ko je ulogovan i njega postaviti.
        AuthenticatedUser user = new AuthenticatedUser();
        user.setId(1L);

        offer.setAuthenticatedUser(user);

        offerService.update(offer);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        offerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
