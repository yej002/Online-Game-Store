package com.jing.storeweb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  The interceptor is used to filter the request from front-end
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     *  if the request is not valid, redirect to the login page
     *  if the request is valid, send it to back-end
     *  If the user is not logged in, the request cannot go through
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // session is used to save data, if not logged in, uid will be null
        if (request.getSession().getAttribute("uid") == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}
