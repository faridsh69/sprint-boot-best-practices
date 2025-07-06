package com.farid.Divar.Controllers;

import com.farid.Divar.Library.Resources.ApiResource;
import com.farid.Divar.Models.User;
import com.farid.Divar.Requests.UserRequest;
import com.farid.Divar.Resources.UserResource;
import com.farid.Divar.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@Validated
public class UserController {

    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @Operation(summary = "list of all users", description = "Returns a list of users")
    @GetMapping
    public ApiResource<List<UserResource>> index() {
        List<User> entities = service.index();

        return new ApiResource<>(entities.stream().map(entity -> UserResource.from(entity, UserResource.class)).toList());
    }

    @GetMapping("{id}")
    public ApiResource<UserResource> show(@PathVariable Integer id) {
        User entity = service.show(id);

        return new ApiResource<>(UserResource.from(entity, UserResource.class));
    }

    @PostMapping
    public ApiResource<UserResource> create(@Valid @RequestBody UserRequest request) {
        User entity = service.create(request);

        return new ApiResource<>(UserResource.from(entity, UserResource.class));
    }

    @PutMapping("{id}")
    public ApiResource<UserResource> update(@PathVariable Integer id, @Valid @RequestBody UserRequest request) {
        User entity = service.update(id, request);

        return new ApiResource<>(UserResource.from(entity, UserResource.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
