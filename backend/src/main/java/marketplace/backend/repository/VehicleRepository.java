package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
}
