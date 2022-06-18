package com.beaconfire.quizonline.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/*")
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("In LoginFilter");
        HttpSession session = request.getSession(false);
//
        if (session != null && session.getAttribute("user") != null) {
            filterChain.doFilter(request, response);
        } else {
            // redirect back to the login page if user is not logged in
            response.sendRedirect("/login");
        }
//        String path = request.getRequestURI();
//        String contentType = request.getContentType();
//        System.out.println("Request URL path : "+path+", Request content type: " + contentType);
//        filterChain.doFilter(request, response);
//        response.sendRedirect("/login");
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();

        return "/login".equals(path) || "/register".equals(path);
    }

//    @Override
//    protected boolean shouldNotFilterAsyncDispatch() {
//        return false;
//    }
}

