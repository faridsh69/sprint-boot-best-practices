package com.farid.Divar;

import com.farid.Divar.Models.Blog;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.BlogRepository;
import com.farid.Divar.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan("com.farid.Divar.Configs")
public class DivarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DivarApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(BlogRepository blogRepository, UserRepository userRepository) {
        return args -> {
            if (blogRepository.count() < 10) {
                Blog blog = new Blog();
                User user = userRepository.findById(1).orElseThrow();
                blog.setUser(user);
                blog.setTitle("Post 2 user 1");
                blogRepository.save(blog);

                System.out.println("Test post inserted.");
            }
        };
    }
}
