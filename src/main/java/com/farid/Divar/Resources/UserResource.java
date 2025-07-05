package com.farid.Divar.Resources;

import com.farid.Divar.Configs.Gender;
import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.User;
import lombok.Getter;

import java.util.List;

@Getter()
public class UserResource extends BaseResource<User> {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private Gender gender;
    private boolean active = false;
    private List<BlogResource> blogs;

    @Override
    public void toResource(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        fullName = user.getFirstName() + " " + user.getLastName();
        email = user.getEmail();
        gender = user.getGender();
        blogs = user.getBlogs().stream().map(blog -> BlogResource.from(blog, BlogResource.class)).toList();
    }
}
