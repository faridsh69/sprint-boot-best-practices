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

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public JsonResponse<List<UserResource>> index() {
		return new JsonResponse<>(repository.findAll().stream().map(UserResource::new).toList());
	}

	@GetMapping("users/{id}")
	public ResponseEntity<JsonResponse<UserResource>> show(@PathVariable int id) {
		return repository.findById(id).map(entity -> {
			return ResponseEntity.ok(new JsonResponse<>(new UserResource(entity)));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@PostMapping("/users")
	public ResponseEntity<JsonResponse<UserResource>> create(@RequestBody User entity) {
		User savedEntity = repository.save(entity);

		return ResponseEntity.ok(new JsonResponse<>(new UserResource(savedEntity)));
	}

	@PutMapping("users/{id}")
	public ResponseEntity<JsonResponse<UserResource>> update(@PathVariable int id, @RequestBody UserRequest updatingEntity) {
		return repository.findById(id).map(entity -> {
			entity.updateData(updatingEntity);
			repository.save(entity);

			return ResponseEntity.ok(new JsonResponse<>(new UserResource(entity)));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<JsonResponse<UserResource>> delete(@PathVariable int id) {
		return repository.findById(id).map(entity -> {
			repository.delete(entity);

			return ResponseEntity.ok(new JsonResponse<>(new UserResource(entity)));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@Autowired
	private AppConfig appConfig;

	public String getAppName() {
		return appConfig.getName();
	}
}
