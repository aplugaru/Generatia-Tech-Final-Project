package GENERATIA.TECH.EmpApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GENERATIA.TECH.EmpApp.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	Optional<Role> findByAuthority(String authority);
	
	

}
