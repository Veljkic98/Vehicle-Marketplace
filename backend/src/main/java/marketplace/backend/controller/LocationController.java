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

import marketplace.backend.dto.requestDTO.LocationRequestDTO;
import marketplace.backend.mapper.LocationMapper;
import marketplace.backend.model.Location;
import marketplace.backend.service.LocationService;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    private LocationMapper mapper = new LocationMapper();

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Location location = locationService.findById(id);

        return new ResponseEntity<>(mapper.toDto(location), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody LocationRequestDTO dto) {

        Location location = locationService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(location), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody LocationRequestDTO dto) {

        Location location = mapper.toEntity(dto);
        location.setId(id);
        
        locationService.update(location);

        return new ResponseEntity<>(mapper.toDto(location), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        locationService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
