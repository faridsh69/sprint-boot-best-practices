package com.farid.Divar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public Iterable<User> index() {
		return this.userRepository.findAll();
	}

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	@Autowired
	private AppConfig appConfig;

	public String getAppName() {
		return appConfig.getName();
	}
}
