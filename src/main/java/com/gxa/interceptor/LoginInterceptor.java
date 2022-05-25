package com.gxa.interceptor;

import com.gxa.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    //    该方法将在Controller处理之前进行调用，可以用于检查用户是否登录了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user ==null){
            request.setAttribute("error","用户未登录");
            request.getRequestDispatcher("/log").forward(request,response);
            return false;
        }
        return true;
    }




}
