package marketplace.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Transactional
    Page<Offer> findAllByAuthenticatedUserId(Long id, Pageable pageable);
}
