package kz.gexabyte.jwtappdemo.controller;

import kz.gexabyte.jwtappdemo.dto.AuthenticationRequestDto;
import kz.gexabyte.jwtappdemo.dto.RegisteredUserDto;
import kz.gexabyte.jwtappdemo.model.User;
import kz.gexabyte.jwtappdemo.security.jwt.JwtTokenProvider;
import kz.gexabyte.jwtappdemo.service.UserService;
import kz.gexabyte.jwtappdemo.service.impl.UserServiceImpl;
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
import org.springframework.web.bind.annotation.*;

import java.rmi.activation.ActivationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, UserServiceImpl userServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
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

            if (user.getActivationCode() != null) {
                throw new ActivationException("User not activated!");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException | ActivationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity activate(@PathVariable String code) {
        boolean isActivated = userServiceImpl.activateUser(code);
        if (isActivated) {
            Map<Object, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK);
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>("User already activated", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody RegisteredUserDto registeredUserDto) {
        User user = userService.findByUsername(registeredUserDto.getUsername());
        if (user == null) {
            userService.register(registeredUserDto.toUser());
            Map<Object, Object> response = new HashMap<>();
            response.put("status", HttpStatus.OK);
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>("Username or email already exist", HttpStatus.BAD_REQUEST);
        }
    }
}