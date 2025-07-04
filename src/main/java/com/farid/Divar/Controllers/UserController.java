package com.farid.Divar.Controllers;

import com.farid.Divar.Configs.AppConfig;
import com.farid.Divar.Library.Resources.ApiResource;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Requests.UserRequest;
import com.farid.Divar.Resources.UserResource;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@Validated
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<ApiResource<List<UserResource>>> index(@RequestParam(required = false) String sort) {
        List<User> users = repository.findAll();
        if (sort.equals("-id")) {
            users.sort(Comparator.comparing(User::getId).reversed());
        } else {
            users.sort(Comparator.comparing(User::getId));
        }

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
    public ResponseEntity<ApiResource<UserResource>> update(@PathVariable int id, @Valid @RequestBody UserRequest request) {
        return repository.findById(id).map(entity -> {
            entity.updateData(request);
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
