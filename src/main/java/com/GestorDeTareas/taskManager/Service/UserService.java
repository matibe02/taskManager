package com.GestorDeTareas.taskManager.Service;

import com.GestorDeTareas.taskManager.DTO.RegisterDTO;
import com.GestorDeTareas.taskManager.Model.AppUser;
import com.GestorDeTareas.taskManager.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegisterDTO dto){
        AppUser user = new AppUser();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Set.of("ROLE_USER")); // rol por defecto
        userRepository.save(user);
    }
}
