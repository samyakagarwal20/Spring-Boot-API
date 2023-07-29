package com.yflash.tech.SampleAPI.service;

import com.yflash.tech.SampleAPI.model.in.PutUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;

public interface UserService {
    User updateUserDetails(PutUserRequest userRequest);
}
