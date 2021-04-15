package marketplace.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.model.Make;
import marketplace.backend.repository.MakeRepository;

@Service
public class MakeService implements MyService<Make> {

    @Autowired
    private MakeRepository makeRepository;

    @Override
    public Make findById(Long id) {

        Make make;

        if ((make = makeRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Make", id);

        return make;
    }

    @Override
    public Make add(Make entity) {

        try {
            return makeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Make with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public Make update(Make entity) {

        if (makeRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Make", entity.getId());

        try {
            return makeRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Make with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (makeRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Make", id);

        makeRepository.deleteById(id);
    }

}
