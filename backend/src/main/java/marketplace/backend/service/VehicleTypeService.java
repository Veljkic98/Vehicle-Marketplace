package marketplace.backend.service;

import marketplace.backend.model.VehicleType;

public interface VehicleTypeService {
    
    public VehicleType findById(Long id);

    public VehicleType add(VehicleType admin);

    public VehicleType update(VehicleType admin);

    public void deleteById(Long id);
}
