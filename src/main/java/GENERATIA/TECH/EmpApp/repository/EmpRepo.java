package GENERATIA.TECH.EmpApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GENERATIA.TECH.EmpApp.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
