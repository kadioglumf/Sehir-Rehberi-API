package com.example.SehirRehberiAPI.Controller;

import com.example.SehirRehberiAPI.Config.JwtTokenUtil;
import com.example.SehirRehberiAPI.shared.Dto.UserDto;
import com.example.SehirRehberiAPI.Model.request.UserDetailsRequestModel;
import com.example.SehirRehberiAPI.Model.request.UserLoginRequestModel;
import com.example.SehirRehberiAPI.Model.response.UserRest;
import com.example.SehirRehberiAPI.Service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginRequestModel user) throws Exception {

        UserDto userDto = userDetailsService.getUserByEmail(user.getEmail());

        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(userDto,returnValue);

        authenticate(user.getEmail(), user.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getEmail());
        returnValue.setToken(jwtTokenUtil.generateToken(userDetails));

        return ResponseEntity.ok(returnValue);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@RequestBody UserDetailsRequestModel user) throws Exception {
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(user,userDto);
        UserDto storedUser = userDetailsService.createUser(userDto);

        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(storedUser,returnValue);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(returnValue.getEmail());

        returnValue.setToken(jwtTokenUtil.generateToken(userDetails));

        return ResponseEntity.ok(returnValue);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
