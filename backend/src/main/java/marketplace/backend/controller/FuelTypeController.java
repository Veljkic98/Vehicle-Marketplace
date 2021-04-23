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

import marketplace.backend.dto.requestDTO.FuelTypeRequestDTO;
import marketplace.backend.mapper.FuelTypeMapper;
import marketplace.backend.model.FuelType;
import marketplace.backend.service.FuelTypeService;

@RestController
@RequestMapping(path = "/api/fuel-types")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private FuelTypeMapper mapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        FuelType type = fuelTypeService.findById(id);

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody FuelTypeRequestDTO dto) {

        FuelType type = fuelTypeService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FuelTypeRequestDTO dto) {

        FuelType type = mapper.toEntity(dto);
        type.setId(id);
        
        fuelTypeService.update(type);

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        fuelTypeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
