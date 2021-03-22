package marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
