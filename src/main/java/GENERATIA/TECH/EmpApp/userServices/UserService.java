package GENERATIA.TECH.EmpApp.userServices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GENERATIA.TECH.EmpApp.models.ApplicationUser;
import GENERATIA.TECH.EmpApp.models.Role;
import GENERATIA.TECH.EmpApp.repository.UserRepo;

@Service
public class UserService implements UserDetailsService{

	@Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
	
}
