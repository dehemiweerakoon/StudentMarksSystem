package com.example.rolebased01.Controller;

import com.example.rolebased01.Entity.Role;
import com.example.rolebased01.Entity.Student;
import com.example.rolebased01.Entity.User;
import com.example.rolebased01.Repository.UserRepository;
import com.example.rolebased01.Security.jwt.JwtUtils;
import com.example.rolebased01.Service.StudentService;
import com.example.rolebased01.payloads.JwtResponse;
import com.example.rolebased01.payloads.LoginRequest;
import com.example.rolebased01.payloads.MessageResponse;
import com.example.rolebased01.payloads.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping("/")
@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    StudentService studentService;


    @PostMapping("/auth/register/user")
    public ResponseEntity<?> registerStudent(@RequestBody StudentUser studentUser) throws Exception {
        if (userRepository.existsByUsername((studentUser.getUsername()))) {

            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken"));
        }
        if(userRepository.existsByEmail(studentUser.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Email is Already used"));
        }
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2,"ROLE_USER"));
        User user = new User(studentUser.getUsername(),passwordEncoder.encode(studentUser.getPassword()),studentUser.getEmail(),roles);
        userRepository.save(user);
        Long id = user.getId();

        Student student = new Student(id,studentUser.getFirstName(),studentUser.getLastName(),studentUser.getYear());

        studentService.registerStudent(student);

        return ResponseEntity.ok().body(new MessageResponse("Student Added"));
    }


    @PostMapping("/auth/register/admin")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if (userRepository.existsByUsername((user.getUsername()))) {

            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken"));
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Email is Already used"));
        }
        User newuser = new User();
        newuser.setUsername(user.getUsername());
        newuser.setEmail(user.getEmail());
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"ROLE_ADMIN"));
        newuser.setRoles(roles);
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newuser);

        return ResponseEntity.ok().body(new MessageResponse("User have been created"));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);

      //  Role roles = new Role(user.getRoles().iterator().next().getId(),);
        return ResponseEntity.ok().body(new JwtResponse(jwt, user.getId(), user.getUsername(), user.getEmail(),user.getRoles().iterator().next().getName()));
    }
}
