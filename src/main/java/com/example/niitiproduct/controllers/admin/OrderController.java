package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.models.Order;
import com.example.niitiproduct.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Get all orders
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        model.addAttribute("order", new OrderDTO());
        return "admin/order/index";
    }

    /**
     * Search by order name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<OrderDTO> orders = orderService.getAll();
            model.addAttribute("orders", orders);
        } else {
            List<Order> orders = orderService.searchByOrderCode(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("orders", orders);
        }
        model.addAttribute("order", new OrderDTO());
        return "admin/order/index";
    }

    /**
     * Edit order
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "admin/order/form";
    }

    /**
     * Update order
     * @param order
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/admin/orders/edit/" + order.getId();
    }

    /**
     * Add order
     * @param model
     * @return
     */
    @GetMapping("/orders/add")
    public String add(Model model) {
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "admin/order/add";
    }

    /**
     * Insert order
     * @param order
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/admin/orders";
    }

    /**
     * Delete order
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        orderService.delete(id);
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        model.addAttribute("order", new OrderDTO());
        return "redirect:/admin/categories";
    }
}