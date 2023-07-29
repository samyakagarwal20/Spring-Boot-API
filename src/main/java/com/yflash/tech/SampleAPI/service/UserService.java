package com.yflash.tech.SampleAPI.service;

import com.yflash.tech.SampleAPI.model.in.DeleteUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;

public interface UserService {
    String deleteUserDetails(Integer id);
}
