package marketplace.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    
    @Transactional
    List<Model> findByMakeId(Long makeId);
}
