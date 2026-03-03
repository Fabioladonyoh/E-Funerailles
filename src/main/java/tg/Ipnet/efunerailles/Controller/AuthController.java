package tg.Ipnet.efunerailles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tg.Ipnet.efunerailles.Entity.User;
import tg.Ipnet.efunerailles.Entity.Role;
import tg.Ipnet.efunerailles.Repository.UserRepository;
import tg.Ipnet.efunerailles.Repository.RoleRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> signUpRequest) {
        String email = signUpRequest.get("email");

        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(Map.of("message", "Cet email est déjà utilisé !"));
        }

        // 1. Création de l'utilisateur
        User newUser = new User();
        newUser.setNom(signUpRequest.get("nom"));
        newUser.setPrenom(signUpRequest.get("prenom"));
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(signUpRequest.get("password")));

        // 2. Gestion du Rôle (Correction : utilisation de findByName et setName)
        Role userRole = roleRepository.findByName("USER").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("USER"); // On utilise setName ici aussi
            return roleRepository.save(newRole);
        });
        
        newUser.setRole(userRole);

        // 3. Sauvegarde
        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of("message", "Utilisateur enregistré avec succès !"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        return userRepository.findByEmail(email)
            .filter(user -> passwordEncoder.matches(password, user.getPassword()))
            .map(user -> ResponseEntity.ok(Map.of(
                "message", "Connexion réussie",
                "email", user.getEmail()
            )))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Email ou mot de passe incorrect")));
    }
}