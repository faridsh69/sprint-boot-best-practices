package com.farid.Divar.Repositories.Contracts;


import com.farid.Divar.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {}

