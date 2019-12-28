package com.example.SehirRehberiAPI.Service.Impl;

import com.example.SehirRehberiAPI.shared.Dto.UserDto;
import com.example.SehirRehberiAPI.Entity.UserEntity;
import com.example.SehirRehberiAPI.Repository.UserRepository;
import com.example.SehirRehberiAPI.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new User(user.getEmail(), user.getEncrypedPassword(),
                new ArrayList<>());
    }

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exist");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncrypedPassword(bcryptEncoder.encode(user.getPassword()));
        userEntity.setEmailVerificationStatus(false);
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByEmail(email);

        BeanUtils.copyProperties(userEntity,returnValue);

        return returnValue;
    }
}
