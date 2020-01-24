package com.example.SehirRehberiAPI.Service.Impl;

import com.example.SehirRehberiAPI.Model.response.ErrorMessages;
import com.example.SehirRehberiAPI.exceptions.UserServiceException;
import com.example.SehirRehberiAPI.shared.Dto.UserDto;
import com.example.SehirRehberiAPI.Entity.UserEntity;
import com.example.SehirRehberiAPI.Repository.UserRepository;
import com.example.SehirRehberiAPI.Service.UserService;
import org.modelmapper.ModelMapper;
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
        if(userRepository.findByEmail(user.getEmail()) != null) throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessage());

        ModelMapper mapper = new ModelMapper();

        UserEntity userEntity = new UserEntity();
        mapper.map(user,userEntity);

        userEntity.setEncrypedPassword(bcryptEncoder.encode(user.getPassword()));
        userEntity.setEmailVerificationStatus(false);
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        mapper.map(storedUserDetails,returnValue);

        return returnValue;
    }

    @Override
    public UserDto updateUser(long user_id, UserDto userDto) {

            ModelMapper mapper = new ModelMapper();
            UserEntity userEntity = userRepository.findById(user_id);
            if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
            userEntity.setFirstName(userDto.getFirstName());
            userEntity.setLastName(userDto.getLastName());
            UserEntity updatedUser = userRepository.save(userEntity);

            return mapper.map(updatedUser,UserDto.class);

    }

    @Override
    public UserDto getUserByEmail(String email) {
//        if(userRepository.findByEmail(email) == null) throw new UserServiceException(ErrorMessages.EMAIL_OR_PASSWORD_INVALID.getErrorMessage());
        ModelMapper mapper = new ModelMapper();

        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.EMAIL_OR_PASSWORD_INVALID.getErrorMessage());

        mapper.map(userEntity,returnValue);
        return returnValue;
    }
}
