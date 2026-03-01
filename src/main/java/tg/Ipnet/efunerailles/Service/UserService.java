package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.User;

public interface UserService {
	
	  List<User> getAllUsers();
	    Optional<User> getUserById(Long id);
	    User createUser(User user);
	    User updateUser(Long id, User userDetails);
	    void deleteUser(Long id);
		User saveUser(User user);

}
