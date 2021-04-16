package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.model.Vehicle;
import marketplace.backend.repository.VehicleRepository;

@Service
public class VehicleService implements MyService<Vehicle> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle findById(Long id) {

        Vehicle vehicle;

        if ((vehicle = vehicleRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Vehicle", id);

        return vehicle;
    }

    @Override
    public Vehicle add(Vehicle entity) {

        return vehicleRepository.save(entity);
    }

    @Override
    public Vehicle update(Vehicle entity) {

        if (vehicleRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Vehicle", entity.getId());

        return vehicleRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {

        if (vehicleRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Vehicle", id);

        vehicleRepository.deleteById(id);
    }

}
