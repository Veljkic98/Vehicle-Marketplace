package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.exception.exceptions.vehicleType.ModelReferenceTypeConstraintViolationException;
import marketplace.backend.exception.exceptions.vehicleType.VehicleTypeNotFoundException;
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
            throw new VehicleTypeNotFoundException(id);

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
            throw new VehicleTypeNotFoundException(entity.getId());

        try {
            return vehicleTypeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Vehicle type with name: " + entity.getName() + ", already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (vehicleTypeRepository.findById(id).orElse(null) == null)
            throw new VehicleTypeNotFoundException(id);

        try {
            vehicleTypeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ModelReferenceTypeConstraintViolationException(id);
        }

    }

}
