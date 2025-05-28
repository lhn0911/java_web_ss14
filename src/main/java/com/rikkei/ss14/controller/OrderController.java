package com.rikkei.ss14.controller;

import com.rikkei.ss14.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String listOrders(Model model, HttpSession session) {
        model.addAttribute("orders", getOrders(session));
        return "orders";
    }

    @GetMapping("/addOrder")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "addOrder";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute Order order, HttpSession session) {
        List<Order> orders = getOrders(session);
        orders.add(order);
        session.setAttribute("orders", orders);
        return "redirect:/order";
    }

    @GetMapping("/editOrder/{id}")
    public String editOrderForm(@PathVariable String id, Model model, HttpSession session) {
        List<Order> orders = getOrders(session);
        for (Order o : orders) {
            if (o.getId().equals(id)) {
                model.addAttribute("order", o);
                return "editOrder";
            }
        }
        return "redirect:/order";
    }

    @PostMapping("/editOrder")
    public String editOrder(@ModelAttribute Order order, HttpSession session) {
        List<Order> orders = getOrders(session);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(order.getId())) {
                orders.set(i, order);
                break;
            }
        }
        session.setAttribute("orders", orders);
        return "redirect:/order";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable String id, HttpSession session) {
        List<Order> orders = getOrders(session);
        orders.removeIf(o -> o.getId().equals(id));
        session.setAttribute("orders", orders);
        return "redirect:/order";
    }

    private List<Order> getOrders(HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
            session.setAttribute("orders", orders);
        }
        return orders;
    }
}