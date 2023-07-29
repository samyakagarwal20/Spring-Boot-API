package com.yflash.tech.SampleAPI.service;

import com.yflash.tech.SampleAPI.model.in.PostUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;

public interface UserService {
    User addUserDetails(PostUserRequest userRequest);
}
