package com.farid.Divar;

import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.Contracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;

@RestController
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public Iterable<User> findAllEmployees() {
		return this.userRepository.findAll();
	}

	@PostMapping("/users")
	public User addOneEmployee(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	@Autowired
	private AppConfig appConfig;

	@GetMapping("/")
	public String index() {
//		User user = new User();
//		System.out.println(user.toString());
		return "Hello World " + appConfig.getName();
	}
}
