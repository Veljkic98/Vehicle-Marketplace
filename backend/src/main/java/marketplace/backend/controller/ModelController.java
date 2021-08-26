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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.backend.dto.requestDTO.ModelRequestDTO;
import marketplace.backend.mapper.ModelMapper;
import marketplace.backend.model.Model;
import marketplace.backend.service.ModelService;

@RestController
@RequestMapping(path = "/api/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelMapper mapper;
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Model model = modelService.findById(id);

        return new ResponseEntity<>(mapper.toDto(model), HttpStatus.OK);
    }

    @GetMapping(path = "/by-page/{makeId}")
    public ResponseEntity<?> getAllByMakeId(@PathVariable Long makeId) {

        List<Model> models = modelService.findAllByMakeId(makeId);

        return new ResponseEntity<>(mapper.toDtoList(models), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ModelRequestDTO dto) {

        Model model = modelService.add(mapper.toEntity(dto));

        return new ResponseEntity<>(mapper.toDto(model), HttpStatus.CREATED);
    }

    // @PutMapping(path = "/{id}")
    // public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ModelRequestDTO dto) {

    //     Model model = mapper.toEntity(dto);
    //     model.setId(id);
        
    //     modelService.update(model);

    //     return new ResponseEntity<>(mapper.toDto(model), HttpStatus.OK);
    // }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        modelService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
