package com.farid.Divar.Resources;

import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.User;
import lombok.Getter;

import java.util.List;

@Getter()
public class UserResource extends BaseResource<User> {
    private Integer id;
    private String firstName;
    private String fullName;
    private List<BlogResource> blogs;

    @Override
    public void toResource(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        fullName = user.getFirstName() + " " + user.getLastName();
        blogs = user.getBlogs().stream().map(blog -> BlogResource.from(blog, BlogResource.class)).toList();
    }
}
