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

import marketplace.backend.dto.requestDTO.VehicleTypeRequestDTO;
import marketplace.backend.mapper.VehicleTypeMapper;
import marketplace.backend.model.VehicleType;
import marketplace.backend.service.VehicleTypeService;

@RestController
@RequestMapping(path = "/api/vehicle-types")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    private VehicleTypeMapper mapper = new VehicleTypeMapper();

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        VehicleType type = vehicleTypeService.findById(id);

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody VehicleTypeRequestDTO dto) {

        VehicleType type = vehicleTypeService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VehicleTypeRequestDTO dto) {

        VehicleType type = mapper.toEntity(dto);
        type.setId(id);
        
        vehicleTypeService.update(type);

        return new ResponseEntity<>(mapper.toDto(type), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        vehicleTypeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
