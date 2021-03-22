package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    
}
