package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tg.Ipnet.efunerailles.Entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByName(String name);
	
}
