package com.farid.Divar.Controllers;

import java.util.List;

import com.farid.Divar.Resources.JsonResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Requests.UserRequest;
import com.farid.Divar.Resources.UserResource;


@RestController
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public JsonResponse<List<UserResource>> index() {
		return new JsonResponse<>(userRepository.findAll().stream().map(UserResource::new).toList());
	}

	@GetMapping("users/{id}")
	public ResponseEntity<JsonResponse<UserResource>> show(@PathVariable int id) {
		return userRepository.findById(id).map(user -> {
			return ResponseEntity.ok(new JsonResponse<>(new UserResource(user)));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@PostMapping("/users")
	public ResponseEntity<JsonResponse<UserResource>> create(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		return ResponseEntity.ok(new JsonResponse<>(new UserResource(savedUser)));
	}

	@PutMapping("users/{id}")
	public ResponseEntity<JsonResponse<UserResource>> update(@PathVariable int id, @RequestBody UserRequest updatingUser) {
		return userRepository.findById(id).map(user -> {
			user.updateData(updatingUser);
			userRepository.save(user);

			return ResponseEntity.ok(new JsonResponse<>(new UserResource(user)));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> delete(@PathVariable int id) {
		return userRepository.findById(id).map(user -> {
			userRepository.delete(user);
			return ResponseEntity.ok(user);
		}).orElseThrow(EntityNotFoundException::new);
	}

	@Autowired
	private AppConfig appConfig;

	public String getAppName() {
		return appConfig.getName();
	}
}
