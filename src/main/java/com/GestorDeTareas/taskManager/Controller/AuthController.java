package com.GestorDeTareas.taskManager.Controller;

import com.GestorDeTareas.taskManager.DTO.RegisterDTO;

import com.GestorDeTareas.taskManager.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login"; //nombre de mi login.html en templates
    }

    // Mostrar formulario del registro
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register"; // apunta a register.html
    }

    // Procesar registro
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO){
        userService.registerNewUser(registerDTO); //guarda usuario con rol y passwordEncoder
        return ResponseEntity.ok("Usuario registrado exitosamente"); // Aviso de usuario creado con exito
    }
}
