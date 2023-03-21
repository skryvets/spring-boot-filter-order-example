package com.example.springfiltertutorial.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
public class HeadersLoggingFilter extends OncePerRequestFilter implements Ordered {

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        log.info("3/3 " + HeadersLoggingFilter.class.getSimpleName());
        Collections.list(request.getHeaderNames())
            .forEach(header -> {
                log.info("Logging Header: {}={}", header, request.getHeader(header));
            });
        chain.doFilter(request, response);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
