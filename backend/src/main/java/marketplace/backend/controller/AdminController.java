package marketplace.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.backend.model.Admin;
import marketplace.backend.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return null;
        // try {
        //     Admin admin = adminService.findById(id);
        //     return new ResponseEntity<>(adminMapper.toDto(admin), HttpStatus.OK);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }
}
