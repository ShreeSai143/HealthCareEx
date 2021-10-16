package in.nareshit.dinesh.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.dinesh.entity.User;
import in.nareshit.dinesh.repo.UserRepository;
import in.nareshit.dinesh.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	public Long saveUser(User user) {
		return repo.save(user).getId();
	}

	public Optional<User> findByUsername(String username) {
		return repo.findByUsername(username);
	}

}
