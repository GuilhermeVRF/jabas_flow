package services;

import models.User;
import repositories.UserRepository;
import utils.Response;

public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Response store(User user) {
		return this.userRepository.store(user);
	}
	
	public User show(int id) {
		return this.userRepository.show(id);
	}

	public boolean update(User user) {
		return this.userRepository.update(user);
	}
}
