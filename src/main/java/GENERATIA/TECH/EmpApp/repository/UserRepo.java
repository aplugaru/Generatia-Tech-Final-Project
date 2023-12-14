package GENERATIA.TECH.EmpApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GENERATIA.TECH.EmpApp.models.ApplicationUser;

@Repository
public interface UserRepo extends JpaRepository<ApplicationUser, Integer>{

	Optional<ApplicationUser> findByUsername (String username); 
}
