package com.farid.Divar.Controllers;

import com.farid.Divar.Library.Controllers.BaseController;
import com.farid.Divar.Models.User;
import com.farid.Divar.Requests.UserRequest;
import com.farid.Divar.Resources.UserResource;
import com.farid.Divar.Services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController extends BaseController<User, UserRequest, UserResource, UserService> {

    public UserController(UserService service) {
        super(service);
    }

    @Override
    protected UserService getService() {
        return this.service;
    }

    @Override
    protected UserResource convertToResource(User entity) {
        return UserResource.from(entity, UserResource.class);
    }
}
