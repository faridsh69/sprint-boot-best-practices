package com.farid.Divar.Services;

import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Requests.UserRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> index() {
        return repository.findAll();
    }

    public User show(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User create(UserRequest request) {
        return repository.save(request.toEntity());
    }

    public User update(Integer id, UserRequest request) {
        User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.updateData(request);

        return repository.save(entity);
    }

    public void delete(Integer id) {
        User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        
        repository.delete(entity);
    }
}
