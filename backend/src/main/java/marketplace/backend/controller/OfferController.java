package marketplace.backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import marketplace.backend.model.Offer;
import marketplace.backend.service.OfferService;

@RestController
@RequestMapping(path = "/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    private OfferMapper mapper = new OfferMapper();

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Offer offer = offerService.findById(id);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody OfferRequestDTO dto) {

        Offer offer = offerService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OfferRequestDTO dto) {

        Offer offer = mapper.toEntity(dto);
        offer.setId(id);

        offerService.update(offer);

        return new ResponseEntity<>(mapper.toDto(offer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        offerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
