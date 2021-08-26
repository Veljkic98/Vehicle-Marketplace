package marketplace.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;
import marketplace.backend.model.Model;
import marketplace.backend.repository.MakeRepository;
import marketplace.backend.repository.ModelRepository;

@Service
public class ModelService implements MyService<Model> {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MakeRepository makeRepository;

    @Override
    public Model findById(Long id) {

        Model model;

        if ((model = modelRepository.findById(id).orElse(null)) == null)
            throw new MyEntityNotFoundException("Model", id);

        return model;
    }

    @Override
    public Model add(Model entity) {

        if (makeRepository.findById(entity.getMake().getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Make", entity.getMake().getId());

        try {
            return modelRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Model with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public Model update(Model entity) {

        if (modelRepository.findById(entity.getId()).orElse(null) == null)
            throw new MyEntityNotFoundException("Model", entity.getId());

        try {
            return modelRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new UniquenessViolationException("Model with name '" + entity.getName() + "' already exists.");
        }
    }

    @Override
    public void deleteById(Long id) {

        if (modelRepository.findById(id).orElse(null) == null)
            throw new MyEntityNotFoundException("Model", id);

        modelRepository.deleteById(id);
    }

    public List<Model> findAllByMakeId(Long makeId) {

        if (makeRepository.findById(makeId).orElse(null) == null)
            throw new MyEntityNotFoundException("Make", makeId);

        List<Model> models = modelRepository.findAllByMakeId(makeId);

        return models;
    }

}
