package in.nareshit.dinesh.service;

import java.util.Optional;

import in.nareshit.dinesh.entity.User;

public interface IUserService {
	
	Long saveUser(User user);
	Optional<User> findByUsername(String username);

}
