package marketplace.backend.service;

import marketplace.backend.model.FuelType;

public interface FuelTypeService {
 
    public FuelType findById(Long id);

    public FuelType add(FuelType admin);

    public FuelType update(FuelType admin);

    public void deleteById(Long id);
}
