package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyConstraintViolationException;
import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.user.EmailOrCompanyNameIntegrityViolationException;
import marketplace.backend.model.Admin;
import marketplace.backend.model.AuthenticatedUser;
import marketplace.backend.repository.AdminRepository;
import marketplace.backend.repository.AuthenticatedUserRepository;

@Service
public class AuthenticatedUserService implements MyService<AuthenticatedUser>, UserDetailsService {

    @Autowired
    private AuthenticatedUserRepository authenticatedUserRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticatedUser findById(Long id) {

        AuthenticatedUser user;

        if ((user = authenticatedUserRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Authenticated user", id);

        return user;
    }

    @Override
    public AuthenticatedUser add(AuthenticatedUser entity) {

        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        try {
            return authenticatedUserRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailOrCompanyNameIntegrityViolationException(entity.getEmail(), entity.getCompanyName());
        }
    }

    @Override
    public AuthenticatedUser update(AuthenticatedUser entity) {

        if (authenticatedUserRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Authenticated user", entity.getId());

        try {
            return authenticatedUserRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailOrCompanyNameIntegrityViolationException(entity.getEmail(), entity.getCompanyName());
        }
    }

    @Override
    public void deleteById(Long id) {

        if (authenticatedUserRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Authenticated user", id);

        try {
            authenticatedUserRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new MyConstraintViolationException("Authenticated user", "Offer", id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AuthenticatedUser user = authenticatedUserRepository.findByEmail(email);

        if (user != null)
            return user;

        Admin admin = adminRepository.findByEmail(email);

        if (admin != null) 
            return admin;
        
        throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
    }

}
