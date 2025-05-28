package com.rikkei.ss14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginBai7Controller {
    @GetMapping("loginBai7")
    public String loginB7() {
        return "loginBai7";
    }

    @PostMapping("loginBai7")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam(required = false) String rememberMe,
                               HttpSession session,
                               HttpServletResponse response,
                               Model model) {
        if ("admin".equals(username) && "123".equals(password)) {
            session.setAttribute("username", username);
            if (rememberMe != null) {
                Cookie userCookie = new Cookie("username", username);
                Cookie passCookie = new Cookie("password", password);

                userCookie.setMaxAge(7 * 24 * 60 * 60);
                passCookie.setMaxAge(7 * 24 * 60 * 60);

                response.addCookie(userCookie);
                response.addCookie(passCookie);
            } else {
                Cookie userCookie = new Cookie("username", null);
                Cookie passCookie = new Cookie("password", null);
                userCookie.setMaxAge(0);
                passCookie.setMaxAge(0);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
            return "welcome";
        }
        model.addAttribute("error",
                "Thông tin xác thực không hợp lệ");
        return "loginBai7";
    }
}