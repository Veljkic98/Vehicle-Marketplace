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

import marketplace.backend.dto.requestDTO.MakeRequestDTO;
import marketplace.backend.mapper.MakeMapper;
import marketplace.backend.model.Make;
import marketplace.backend.service.MakeService;

@RestController
@RequestMapping(path = "/api/makes")
public class MakeController {

    @Autowired
    private MakeService makeService;

    @Autowired
    private MakeMapper mapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Make make = makeService.findById(id);

        return new ResponseEntity<>(mapper.toDto(make), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody MakeRequestDTO dto) {

        Make make = makeService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(make), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MakeRequestDTO dto) {

        Make make = mapper.toEntity(dto);
        make.setId(id);
        
        makeService.update(make);

        return new ResponseEntity<>(mapper.toDto(make), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        makeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
