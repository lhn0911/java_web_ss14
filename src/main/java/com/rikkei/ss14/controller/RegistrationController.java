package com.rikkei.ss14.controller;

import com.rikkei.ss14.dto.UserDTO;
import com.rikkei.ss14.model.User;
import com.rikkei.ss14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class RegistrationController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("userDTO") UserDTO userDto, BindingResult bindingResult, Model model, Locale locale) {
        if (userDto.getUsername() == null || userDto.getUsername().trim().isEmpty()) {
            bindingResult.rejectValue("username", "", messageSource.getMessage("error.username.required", null, locale));
        }
        if (userDto.getPassword() == null || userDto.getPassword().trim().isEmpty()) {
            bindingResult.rejectValue("password", "", messageSource.getMessage("error.password.required", null, locale));
        }
        if (userDto.getConfirmPassword() == null || !userDto.getConfirmPassword().equals(userDto.getPassword())) {
            bindingResult.rejectValue("confirmPassword", "", messageSource.getMessage("error.confirmPassword.mismatch", null, locale));
        }
        if (userDto.getEmail() == null || !userDto.getEmail().matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            bindingResult.rejectValue("email", "", messageSource.getMessage("error.email.invalid", null, locale));
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        boolean result = userService.create(user);

        model.addAttribute("message", messageSource.getMessage("register.success", null, locale));
        return "registerSuccess";
    }
}