package marketplace.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    
    @Transactional
    Page<Model> findByMakeId(Long id, Pageable pageable);
}
