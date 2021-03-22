package marketplace.backend.service;

import marketplace.backend.model.Model;

public interface ModelService {
    
    public Model findById(Long id);

    public Model add(Model admin);

    public Model update(Model admin);

    public void deleteById(Long id);
}
