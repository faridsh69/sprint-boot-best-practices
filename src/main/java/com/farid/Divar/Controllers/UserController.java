package com.farid.Divar.Controllers;

import com.farid.Divar.Library.ApiResource;
import com.farid.Divar.Library.ResourceAbstract;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Resources.UserResource;

@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

//	@GetMapping("/users")
//	public ApiResource<List<UserResource>> index() {
//		return new ApiResource<>(repository.findAll().stream().map((entity) -> {return new UserResource(entity);}).toList());
//	}

	@GetMapping("users/{id}")
	public ResponseEntity<ApiResource<UserResource>> show(@PathVariable int id) {
		User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
		UserResource resource = UserResource.from(entity, UserResource.class);

		return ResponseEntity.ok(new ApiResource<>(resource));
	}

//	@PostMapping("/users")
//	public ResponseEntity<ApiResource<UserResource>> create(@RequestBody User entity) {
//		User savedEntity = repository.save(entity);
//
//		return ResponseEntity.ok(new ApiResource<>(new UserResource(savedEntity)));
//	}

//	@PutMapping("users/{id}")
//	public ResponseEntity<ApiResource<UserResource>> update(@PathVariable int id, @RequestBody UserRequest updatingEntity) {
//		return repository.findById(id).map(entity -> {
//			entity.updateData(updatingEntity);
//			repository.save(entity);
//
//			return ResponseEntity.ok(new ApiResource<>(new UserResource(entity)));
//		}).orElseThrow(EntityNotFoundException::new);
//	}

//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<ApiResource<UserResource>> delete(@PathVariable int id) {
//		return repository.findById(id).map(entity -> {
//			repository.delete(entity);
//
//			return ResponseEntity.ok(new ApiResource<>(new UserResource(entity)));
//		}).orElseThrow(EntityNotFoundException::new);
//	}

	@Autowired
	private AppConfig appConfig;

	public String getAppName() {
		return appConfig.getName();
	}
}
