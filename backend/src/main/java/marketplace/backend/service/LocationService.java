package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.model.Location;
import marketplace.backend.repository.LocationRepository;

@Service
public class LocationService implements MyService<Location> {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findById(Long id) {

        Location location;

        if ((location = locationRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Locaiton", id);

        return location;
    }

    @Override
    public Location add(Location entity) {

        try {
            return locationRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Location with city '" + entity.getCity() + "' and country '"
                    + entity.getCountry() + "' already exists.");
        }
    }

    @Override
    public Location update(Location entity) {

        if (locationRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Location", entity.getId());

        try {
            return locationRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Location with city '" + entity.getCity() + "' and country '"
                    + entity.getCountry() + "' already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (locationRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Location", id);

        locationRepository.deleteById(id);
    }

}
