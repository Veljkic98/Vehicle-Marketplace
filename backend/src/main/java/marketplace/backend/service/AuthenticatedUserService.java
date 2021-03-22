package marketplace.backend.service;

import marketplace.backend.model.AuthenticatedUser;

public interface AuthenticatedUserService {
    
    public AuthenticatedUser findById(Long id);

    public AuthenticatedUser add(AuthenticatedUser admin);

    public AuthenticatedUser update(AuthenticatedUser admin);

    public void deleteById(Long id);
}
