package marketplace.backend.service;

import marketplace.backend.model.Vehicle;

public interface VehicleService {
    
    public Vehicle findById(Long id);

    public Vehicle add(Vehicle admin);

    public Vehicle update(Vehicle admin);

    public void deleteById(Long id);
}
