package com.rikkei.ss14.controller;

import com.rikkei.ss14.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("products")
    public String listProducts(Model model, HttpServletRequest request) {
        List<Product> products = getProductsFromCookie(request);
        model.addAttribute("products", products);
        return "listProduct";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        List<Product> products = getProductsFromCookie(request);
        product.setId(generateId(products));
        products.add(product);
        saveToCookie(response, products);
        return "redirect:/products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        List<Product> products = getProductsFromCookie(request);
        products.removeIf(p -> p.getId() == id);
        saveToCookie(response, products);
        return "redirect:/products";
    }

    private List<Product> getProductsFromCookie(HttpServletRequest request) {
        List<Product> list = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return list;

        for (Cookie cookie : cookies) {
            if ("products".equals(cookie.getName())) {
                try {
                    String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    String[] items = value.split("\\|");
                    for (String item : items) {
                        String[] parts = item.split("-");
                        if (parts.length == 3) {
                            int id = Integer.parseInt(parts[0]);
                            String name = parts[1];
                            double price = Double.parseDouble(parts[2]);
                            list.add(new Product(id, name, price,1));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    private void saveToCookie(HttpServletResponse response, List<Product> products) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            if (sb.length() > 0) sb.append("|");
            sb.append(p.getId()).append("-").append(p.getName()).append("-").append(p.getPrice());
        }
        String encoded = URLEncoder.encode(sb.toString(), "UTF-8");
        Cookie cookie = new Cookie("products", encoded);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

    private int generateId(List<Product> products) {
        return products.stream().mapToInt(Product::getId).max().orElse(0) + 1;
    }
}
