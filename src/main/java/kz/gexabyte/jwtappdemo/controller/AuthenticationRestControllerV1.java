package kz.gexabyte.jwtappdemo.controller;


import kz.gexabyte.jwtappdemo.dto.AuthenticationRequestDto;
import kz.gexabyte.jwtappdemo.dto.RegisteredUserDto;
import kz.gexabyte.jwtappdemo.dto.UserDto;
import kz.gexabyte.jwtappdemo.model.User;
import kz.gexabyte.jwtappdemo.security.jwt.JwtTokenProvider;
import kz.gexabyte.jwtappdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody RegisteredUserDto registeredUserDto) {
        try {
            User user = userService.findByUsername(registeredUserDto.getUsername());
            if (user == null) {
                userService.register(registeredUserDto.toUser());
                return new ResponseEntity<>("Successful result", HttpStatus.OK);
            } else {
                return  new ResponseEntity<>("user with the same username already exists",HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
