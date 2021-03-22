package marketplace.backend.service;

import marketplace.backend.model.Make;

public interface MakeService {
    
    public Make findById(Long id);

    public Make add(Make admin);

    public Make update(Make admin);

    public void deleteById(Long id);
}
