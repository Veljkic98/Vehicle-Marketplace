package marketplace.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.backend.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Transactional
    Admin findByEmail(String email);
    
}
