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

    @GetMapping(path = "/by-page")
    public ResponseEntity<?> findAll(Pageable pageable) {

        Page<Make> models = makeService.findAll(pageable);

        return new ResponseEntity<>(mapper.toDtoPage(models), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody MakeRequestDTO dto) {

        Make make = makeService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(make), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        makeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
