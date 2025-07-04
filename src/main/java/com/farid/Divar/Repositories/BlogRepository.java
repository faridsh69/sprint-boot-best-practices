package com.farid.Divar.Repositories;

import com.farid.Divar.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
//    List<Blog> findByUserId(Integer userId);
}

