package marketplace.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.exception.exceptions.vehicleType.ModelReferenceConstraintViolationException;
import marketplace.backend.model.VehicleType;
import marketplace.backend.repository.VehicleTypeRepository;

@Service
public class VehicleTypeService implements MyService<VehicleType> {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public VehicleType findById(Long id) {

        VehicleType type;

        if ((type = vehicleTypeRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Vehicle type", id);

        return type;
    }

    @Override
    public VehicleType add(VehicleType entity) {

        try {
            return vehicleTypeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Vehicle type with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public VehicleType update(VehicleType entity) {

        if (vehicleTypeRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Vehicle type", entity.getId());

        try {
            return vehicleTypeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Vehicle type with name: " + entity.getName() + ", already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (vehicleTypeRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Vehicle type", id);

        try {
            vehicleTypeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ModelReferenceConstraintViolationException(id, "Vehicle type");
        }
    }

    public List<VehicleType> findAll() {
        
        return vehicleTypeRepository.findAll();
    }

}
