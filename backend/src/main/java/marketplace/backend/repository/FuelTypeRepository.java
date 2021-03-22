package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    
}
