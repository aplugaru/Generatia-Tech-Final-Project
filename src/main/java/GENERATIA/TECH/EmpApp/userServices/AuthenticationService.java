package GENERATIA.TECH.EmpApp.userServices;

import java.util.HashSet;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GENERATIA.TECH.EmpApp.models.ApplicationUser;
import GENERATIA.TECH.EmpApp.models.LoginResponseDTO;
import GENERATIA.TECH.EmpApp.models.Role;
import GENERATIA.TECH.EmpApp.repository.RoleRepo;
import GENERATIA.TECH.EmpApp.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepo.save(new ApplicationUser(0, username, encodedPassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepo.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }


}
