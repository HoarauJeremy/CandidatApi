package org.example.candidatapi.controller;

import org.example.candidatapi.config.JwtUtils;
import org.example.candidatapi.entity.Utilisateur;
import org.example.candidatapi.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
//@Slf4j
class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    AuthController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        if (utilisateurService.findByEmail(utilisateur.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Utilisateur already exists");
        }
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return ResponseEntity.ok(utilisateurService.save(utilisateur));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        System.out.println("start login");

        try {

            System.out.println("start in try");

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getMotDePasse()));
            if (authentication.isAuthenticated()) {
                Map<String, Object> authData = new HashMap<>();
                authData.put("token", jwtUtils.generateToken(utilisateur.getEmail()));
                authData.put("type", "Bearer");
                return ResponseEntity.ok(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } catch (AuthenticationException e) {
            System.out.println("Error login");
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
