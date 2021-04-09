package marketplace.backend.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.user.UserNotFoundException;
import marketplace.backend.model.Admin;
import marketplace.backend.repository.AdminRepository;

@Service
public class AdminServiceImpl implements MyService<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {

        Admin admin;

        if ((admin = adminRepository.findById(id).orElse(null)) == null)
            // throw new EntityNotFoundException();
            throw new UserNotFoundException(id);

        return admin;
    }

    @Override
    public Admin add(Admin admin) {

        return adminRepository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {

        if (adminRepository.findById(admin.getId()).orElse(null) == null)
            throw new EntityNotFoundException();

        return adminRepository.save(admin);
    }

    @Override
    public void deleteById(Long id) {

        if (adminRepository.findById(id).orElse(null) == null)
            throw new EntityNotFoundException();

        adminRepository.deleteById(id);
    }

}
