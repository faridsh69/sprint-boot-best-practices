package com.farid.Divar.Resources;

import com.farid.Divar.Library.Resources.BaseResource;
import com.farid.Divar.Models.User;
import lombok.Getter;

@Getter()
public class UserResource extends BaseResource<User> {
    private Integer id;
    private String firstName;
    private String fullName;

    @Override
    public void toResource(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        fullName = entity.getFirstName() + " " + entity.getLastName();
    }
}
