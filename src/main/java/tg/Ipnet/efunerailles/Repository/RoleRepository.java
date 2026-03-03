package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.Ipnet.efunerailles.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    // Correction ici : on utilise 'Name' car c'est le nom du champ dans l'entité Role
    Optional<Role> findByName(String name);
}