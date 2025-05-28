    package com.rikkei.ss14.controller;

    import com.rikkei.ss14.model.OrderB8;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import javax.servlet.http.HttpSession;
    import java.util.ArrayList;
    import java.util.List;

    @Controller
    @RequestMapping("orderB8")
    public class OrderBai8Controller {
        @GetMapping
        public String orderB8(Model model) {
            model.addAttribute("orderB8", new OrderB8());
            return "orderB8";
        }

        @PostMapping("/submit")
        public String submitOrder(@ModelAttribute("orderB8") OrderB8 orderB8,
                                  HttpSession session,
                                  Model model) {
            List<OrderB8> orders = getOrders(session);
            orders.add(orderB8);
            session.setAttribute("ordersB8", orders);
            model.addAttribute("message", "Đặt hàng thành công!");
            return "orderB8";
        }

        @GetMapping("/orderList")
        public String viewOrders(HttpSession session, Model model) {
            List<OrderB8> orders = (List<OrderB8>) session.getAttribute("ordersB8");
            if (orders == null) {
                orders = new ArrayList<>();
            }
            model.addAttribute("ordersB8", orders);
            return "orderListB8";
        }

        private List<OrderB8> getOrders(HttpSession session) {
            List<OrderB8> orders = (List<OrderB8>) session.getAttribute("ordersB8");
            if (orders == null) {
                orders = new ArrayList<>();
                session.setAttribute("ordersB8", orders);
            }
            return orders;
        }
    }