package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.Ipnet.efunerailles.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Recherche un utilisateur par son email (pour le login)
    Optional<User> findByEmail(String email);
    
    // Vérifie si un email existe déjà (pour le register)
    boolean existsByEmail(String email);
}