package marketplace.backend.service;

import marketplace.backend.model.Location;

public interface LocationService {
    
    public Location findById(Long id);

    public Location add(Location admin);

    public Location update(Location admin);

    public void deleteById(Long id);
}
