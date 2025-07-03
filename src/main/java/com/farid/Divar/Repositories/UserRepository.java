package com.farid.Divar.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.farid.Divar.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
