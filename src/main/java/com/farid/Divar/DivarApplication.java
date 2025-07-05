package com.farid.Divar;

import com.farid.Divar.Repositories.BlogRepository;
import com.farid.Divar.Repositories.TagRepository;
import com.farid.Divar.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan("com.farid.Divar.Configs")
@EnableCaching
public class DivarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DivarApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(BlogRepository blogRepository, UserRepository userRepository, TagRepository tagRepository) {
        return args -> {
//            if (blogRepository.count() < 10) {
//                User user = userRepository.findById(1).orElseThrow();
//
//                Blog blog = new Blog();
//                blog.setUser(user);
//                blog.setTitle("Post 2 user 1");
//                blog.setPrice(120);
//
//                Tag tag = new Tag();
//                tag.setTitle("Tag number 1");
//                tag = tagRepository.save(tag);
//
//                blog.setTags(List.of(tag));
//
//                blogRepository.save(blog);
//
//                System.out.println("Test post inserted.");
//            }
        };
    }
}
