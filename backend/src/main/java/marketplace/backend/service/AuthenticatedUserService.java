package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.user.exceptions.*;
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
            throw new UserNotFoundException(id);

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
            throw new UserNotFoundException(entity.getId());

        try {
            return authenticatedUserRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EmailOrCompanyNameIntegrityViolationException(entity.getEmail(), entity.getCompanyName());
        }
    }

    @Override
    public void deleteById(Long id) {

        if (authenticatedUserRepository.findById(id).orElse(null) == null)
            throw new UserNotFoundException(id);

        try {
            authenticatedUserRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new UserOffersConstraintViolationException(id);
        }

    }
}
