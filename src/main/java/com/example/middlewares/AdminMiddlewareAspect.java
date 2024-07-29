package com.example.middlewares;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.api.utils.JwtUtils;

@Aspect
@Component
public class AdminMiddlewareAspect {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AdminMiddlewareAspect(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Before("@annotation(AdminMiddleware)")
    public void checkAdminMiddleware() throws Throwable {
        String cookie = request.getHeader("Cookie");
        if (cookie == null || cookie.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("Unauthorized");
        }

        String[] tokenParts = cookie.split("=");
        if (tokenParts.length != 2) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("Unauthorized");
        }

        String token = tokenParts[1];
        Claims claims = JwtUtils.validateToken(token);
        if (claims == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("Unauthorized");
        }
    }
}