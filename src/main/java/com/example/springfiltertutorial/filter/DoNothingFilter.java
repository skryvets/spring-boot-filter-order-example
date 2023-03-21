package com.example.springfiltertutorial.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
//this filter is instantiated inside MyAppConfiguration.class via FilterRegistrationBean
public class DoNothingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain filterChain)
        throws ServletException, IOException {
        log.info("1/3 " + DoNothingFilter.class.getSimpleName());
        filterChain.doFilter(request, response);
    }
}
