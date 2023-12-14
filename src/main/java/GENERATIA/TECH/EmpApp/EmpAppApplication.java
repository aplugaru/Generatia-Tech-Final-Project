package GENERATIA.TECH.EmpApp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import GENERATIA.TECH.EmpApp.models.ApplicationUser;
import GENERATIA.TECH.EmpApp.models.Role;
import GENERATIA.TECH.EmpApp.repository.RoleRepo;
import GENERATIA.TECH.EmpApp.repository.UserRepo;

@SpringBootApplication
public class EmpAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}
