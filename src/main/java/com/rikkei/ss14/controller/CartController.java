package com.rikkei.ss14.controller;

import com.rikkei.ss14.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CartController {

    @GetMapping("/form")
    public String showForm(Model model, HttpServletRequest request) {
        model.addAttribute("product", new Product());

        List<String> productNames = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().startsWith("product_")) {
                    productNames.add(c.getValue());
                }
            }
        }
        model.addAttribute("savedProducts", productNames);
        return "form";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute Product product,
                            HttpSession session,
                            HttpServletResponse response) {

        Cookie cookie = new Cookie("product_" + UUID.randomUUID(), product.getName());
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;
        for (Product p : cart) {
            if (p.getId() == product.getId()) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            cart.add(product);
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }


    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        model.addAttribute("cart", cart != null ? cart : new ArrayList<>());
        return "cart";
    }

    @GetMapping("/remove")
    public String removeFromCart(@RequestParam("id") int id, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(p -> p.getId() == id);
        }
        return "redirect:/cart";
    }

}