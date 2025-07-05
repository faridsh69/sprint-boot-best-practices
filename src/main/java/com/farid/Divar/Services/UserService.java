package com.farid.Divar.Services;

import com.farid.Divar.Library.Services.BaseService;
import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import com.farid.Divar.Requests.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRequest> {

    public UserService(UserRepository userRepository) {
        super(userRepository, User.class);
    }
}
