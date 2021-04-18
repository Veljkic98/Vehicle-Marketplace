package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyConstraintViolationException;
import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.user.EmailOrCompanyNameIntegrityViolationException;
import marketplace.backend.model.AuthenticatedUser;
import marketplace.backend.repository.AuthenticatedUserRepository;

@Service
public class AuthenticatedUserService implements MyService<AuthenticatedUser> {

    @Autowired
    private AuthenticatedUserRepository authenticatedUserRepository;

    @Override
    public AuthenticatedUser findById(Long id) {

        AuthenticatedUser user;

        if ((user = authenticatedUserRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Authenticated user", id);

        return user;
    }

    @Override
    public AuthenticatedUser add(AuthenticatedUser entity) {

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
}
