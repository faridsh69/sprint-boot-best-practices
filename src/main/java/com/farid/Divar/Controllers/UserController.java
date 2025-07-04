package com.farid.Divar.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;
import com.farid.Divar.Library.Resources.ApiResource;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Requests.UserRequest;
import com.farid.Divar.Resources.UserResource;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/users")
@Validated
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<ApiResource<List<UserResource>>> index() {
		List<User> users = repository.findAll();
		List<UserResource> userResources =
				users.stream().map(user -> UserResource.from(user, UserResource.class)).toList();

		return ResponseEntity.ok(new ApiResource<>(userResources));
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResource<UserResource>> show(@PathVariable int id) {
		User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
		UserResource resource = UserResource.from(entity, UserResource.class);

		return ResponseEntity.ok(new ApiResource<>(resource));
	}

	@PostMapping
	public ResponseEntity<ApiResource<UserResource>> create(@Valid @RequestBody UserRequest request) {
		User entity = request.toEntity();
		User savedEntity = repository.save(entity);
		UserResource resource = UserResource.from(savedEntity, UserResource.class);

		return ResponseEntity.ok(new ApiResource<>(resource));
	}

	@PutMapping("{id}")
	public ResponseEntity<ApiResource<UserResource>> update(@PathVariable int id,
			@RequestBody UserRequest updatingEntity) {
		return repository.findById(id).map(entity -> {
			entity.updateData(updatingEntity);
			repository.save(entity);
			UserResource resource = UserResource.from(entity, UserResource.class);

			return ResponseEntity.ok(new ApiResource<>(resource));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResource<User>> delete(@PathVariable int id) {
		return repository.findById(id).map(entity -> {
			repository.delete(entity);

			return ResponseEntity.ok(new ApiResource<>(entity));
		}).orElseThrow(EntityNotFoundException::new);
	}

	@Autowired
	private AppConfig appConfig;

	public String getAppName() {
		return appConfig.getName();
	}
}
