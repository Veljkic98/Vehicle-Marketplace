package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Make;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
    
}
