package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.user.*;
import marketplace.backend.model.Admin;
import marketplace.backend.repository.AdminRepository;

@Service
public class AdminService implements MyService<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {

        Admin admin;

        if ((admin = adminRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Admin", id);

        return admin;
    }

    @Override
    // TODO: Verovatno ce se menjati kad security bude uradjen
    public Admin add(Admin entity) {

        try {
            return adminRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailIntegrityViolationException(entity.getEmail());
        }
    }

    @Override
    public Admin update(Admin entity) {

        if (adminRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Admin", entity.getId());

        try {
            return adminRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailIntegrityViolationException(entity.getEmail());
        }
    }

    @Override
    public void deleteById(Long id) {

        if (adminRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Admin", id);

        adminRepository.deleteById(id);
    }

}
