package com.farid.Divar.Commands;

import com.farid.Divar.Models.Blog;
import com.farid.Divar.Models.Tag;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.BlogRepository;
import com.farid.Divar.Repositories.TagRepository;
import com.farid.Divar.Repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSeeder {

    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final BlogRepository blogRepository;

    public UserSeeder(UserRepository userRepository, TagRepository tagRepository, BlogRepository blogRepository) {
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.blogRepository = blogRepository;
    }

    public void seed() {
        User user = userRepository.findById(1).orElseThrow();

        Tag tag = new Tag();
        tag.setTitle("Tag number 1");
        tag = tagRepository.save(tag);

        Blog blog = new Blog();
        blog.setUser(user);
        blog.setTitle("Blog 2 user 1");
        blog.setPrice(120);
        blog.setTags(List.of(tag));
        blogRepository.save(blog);

        System.out.println("Test blog inserted.");
    }
}
