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

import marketplace.backend.dto.requestDTO.AuthenticatedUserRequestDTO;
import marketplace.backend.mapper.AuthenticatedUserMapper;
import marketplace.backend.model.AuthenticatedUser;
import marketplace.backend.service.AuthenticatedUserService;

@RestController
@RequestMapping(path = "/api/authenticated-users")
public class AuthenticatedUserController {
    
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    private AuthenticatedUserMapper authenticatedUserMapper = new AuthenticatedUserMapper();

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        
        AuthenticatedUser user = authenticatedUserService.findById(id);

        return new ResponseEntity<>(authenticatedUserMapper.toDto(user), HttpStatus.OK);
    }

    @PostMapping
    // TODO: ovo ce se prepraviti kada se uradi security
    // Metoda je za registraciju na sistem
    public ResponseEntity<?> add(@Valid @RequestBody AuthenticatedUserRequestDTO dto) {

        AuthenticatedUser user = authenticatedUserService.add(authenticatedUserMapper.toEntity(dto));

        return new ResponseEntity<>(authenticatedUserMapper.toDto(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AuthenticatedUserRequestDTO dto) {

        AuthenticatedUser user = authenticatedUserMapper.toEntity(dto);
        user.setId(id);

        authenticatedUserService.update(user);

        return new ResponseEntity<>(authenticatedUserMapper.toDto(user), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        authenticatedUserService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
