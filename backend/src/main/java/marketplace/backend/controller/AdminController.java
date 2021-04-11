package marketplace.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import marketplace.backend.dto.requestDTO.AdminRequestDTO;
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

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AdminRequestDTO adminRequestDTO) {

        Admin admin = adminService.add(adminMapper.toEntity(adminRequestDTO));

        return new ResponseEntity<>(adminMapper.toDto(admin), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AdminRequestDTO adminRequestDTO) {

        Admin admin = adminMapper.toEntity(adminRequestDTO);
        admin.setId(id);
        adminService.update(admin);

        return new ResponseEntity<>(adminMapper.toDto(admin), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        adminService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
