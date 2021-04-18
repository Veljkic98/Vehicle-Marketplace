package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.model.FuelType;
import marketplace.backend.repository.FuelTypeRepository;

@Service
public class FuelTypeService implements MyService<FuelType> {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Override
    public FuelType findById(Long id) {

        FuelType type;

        if ((type = fuelTypeRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Fuel type", id);

        return type;
    }

    @Override
    public FuelType add(FuelType entity) {

        try {
            return fuelTypeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Fuel type with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public FuelType update(FuelType entity) {

        if (fuelTypeRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Fuel type", entity.getId());

        try {
            return fuelTypeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Fuel type with name: " + entity.getName() + ", already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (fuelTypeRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Fuel type", id);

        fuelTypeRepository.deleteById(id);
    }

}
