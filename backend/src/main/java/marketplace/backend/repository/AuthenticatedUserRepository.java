package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.AuthenticatedUser;

@Repository
public interface AuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, Long> {
    
}
