package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tg.Ipnet.efunerailles.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);


}
