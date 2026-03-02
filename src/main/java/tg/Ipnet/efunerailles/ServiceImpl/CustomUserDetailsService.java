package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tg.Ipnet.efunerailles.Entity.User;
import tg.Ipnet.efunerailles.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec email: " + email));

        // Conversion enum Role -> String pour Spring Security
        String roleName = user.getRole().name(); // name() renvoie "ADMINISTRATEUR", "LOGISTICIEN", "AGENT"

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(roleName) // Spring Security attend le nom du rôle sans "ROLE_" ici
                .build();
    }
}