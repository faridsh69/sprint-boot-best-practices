package com.farid.Divar.Repositories;


import com.farid.Divar.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
