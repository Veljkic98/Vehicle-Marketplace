package marketplace.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.backend.mapper.AdminMapper;
import marketplace.backend.model.Admin;
import marketplace.backend.service.AdminServiceImpl;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    private AdminMapper adminMapper = new AdminMapper();

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Admin admin = adminService.findById(id);

        return new ResponseEntity<>(adminMapper.toDto(admin), HttpStatus.OK);
    }

    // TODO: ovo obrisati i prebaciti u globalnu klasu
    // @ExceptionHandler(UserNotFoundException.class)
    // public ResponseEntity<Error> adminNotFound(UserNotFoundException e) {

    //     Long userId = e.getUserId();

    //     Error error = new Error(7, "User with id: " + userId + ", not found");

    //     return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    // }
}
