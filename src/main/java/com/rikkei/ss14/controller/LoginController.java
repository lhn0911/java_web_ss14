package com.rikkei.ss14.controller;

import com.rikkei.ss14.model.UserB1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private boolean authenticate(UserB1 user) {
        return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserB1());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserB1 user,
                        Model model,
                        HttpSession session) {
        if (authenticate(user)) {
            session.setAttribute("loggedInUser", user.getUsername());
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "welcome";
    }
}
