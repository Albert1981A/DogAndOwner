package com.AlbertAbuav.DogAndOwner.filters;

import com.AlbertAbuav.DogAndOwner.exceptions.SecurityException01;
import com.AlbertAbuav.DogAndOwner.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Order(1)
public class TokenFilter implements Filter {

    private final TokenManager tokenManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter in action!");

        String url = ((HttpServletRequest)servletRequest).getRequestURI();
        if (url.endsWith("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = ((HttpServletRequest)servletRequest).getHeader("Authorization");

        try {
            tokenManager.isExist(token);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (SecurityException01 e) {
            System.out.println(e.getMessage());
            ((HttpServletResponse)servletResponse).setStatus(401);
        }
    }
}
