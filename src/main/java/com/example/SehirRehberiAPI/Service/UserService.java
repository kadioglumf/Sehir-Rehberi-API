package com.example.SehirRehberiAPI.Service;

import com.example.SehirRehberiAPI.shared.Dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String  email);
    UserDto updateUser(long user_id,UserDto userDto);

}
