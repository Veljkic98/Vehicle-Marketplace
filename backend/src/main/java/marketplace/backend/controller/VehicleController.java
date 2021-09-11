package marketplace.backend.controller;

import java.util.List;

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

import marketplace.backend.dto.requestDTO.VehicleRequestDTO;
import marketplace.backend.mapper.VehicleMapper;
import marketplace.backend.model.Vehicle;
import marketplace.backend.service.VehicleService;

@RestController
@RequestMapping(path = "/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMapper mapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Vehicle vehicle = vehicleService.findById(id);

        return new ResponseEntity<>(mapper.toDto(vehicle), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {

        List<Vehicle> vehicles = vehicleService.findAll();

        return new ResponseEntity<>(mapper.toDtoList(vehicles), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody VehicleRequestDTO dto) {

        Vehicle vehicle = vehicleService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(vehicle), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VehicleRequestDTO dto) {

        Vehicle vehicle = mapper.toEntity(dto);
        vehicle.setId(id);
        
        vehicleService.update(vehicle);

        return new ResponseEntity<>(mapper.toDto(vehicle), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        vehicleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
