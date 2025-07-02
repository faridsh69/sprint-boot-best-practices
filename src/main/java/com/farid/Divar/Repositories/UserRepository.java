package com.farid.Divar.Repositories;


import org.springframework.data.repository.CrudRepository;
import com.farid.Divar.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}

