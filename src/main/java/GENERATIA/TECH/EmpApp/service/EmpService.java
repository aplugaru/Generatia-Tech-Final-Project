package GENERATIA.TECH.EmpApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GENERATIA.TECH.EmpApp.entity.Employee;
import GENERATIA.TECH.EmpApp.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}

}
