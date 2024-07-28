package com.example.api.auth;

import java.time.LocalDate;
import java.util.Optional;
import com.example.api.utils.HashUtils;
import com.example.api.utils.JwtUtils;
import com.example.database.UserEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public AuthModel registerUser(AuthModel user) {

        if (user.username == null || user.email == null || user.password == null) {
            return null;
        }

        String hashedPassword = HashUtils.hash(user.password);

        UserEntity newUser = new UserEntity(
                user.username,
                user.email,
                hashedPassword,
                "user",
                LocalDate.now().toString(),
                LocalDate.now().toString()
        );

        if (authRepository.findByEmail(user.email).isPresent()) {
            return null;
        }

        authRepository.save(newUser);
    
        return user;
    }
    
    public AuthModel loginUser(AuthModel user, HttpServletResponse response) {
        if (user.email == null || user.password == null) {
            return null;
        }

        Optional<UserEntity> userOptional = authRepository.findByEmail(user.email);
        if (userOptional.isPresent()) {
            UserEntity userFound = userOptional.get();
            if (HashUtils.verifyHash(user.password, userFound.password)) {
                String token = JwtUtils.generateToken(userFound.id);
                Cookie cookie = new Cookie("token", token);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(86400);
                cookie.setPath("/");
                response.addCookie(cookie);
                return user;
            }
        }

        return null;
    }

    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    Cookie newCookie = new Cookie("token", "");
                    newCookie.setHttpOnly(true);
                    newCookie.setMaxAge(0);
                    newCookie.setPath("/");
                    response.addCookie(newCookie);
                    return "User logged out";
                }
            }
        }
        return "User not logged out";
    }
}