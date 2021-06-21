package com.AlbertAbuav.DogAndOwner.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import java.io.IOException;

@Component
@RequestMapping("clinic")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }
}
