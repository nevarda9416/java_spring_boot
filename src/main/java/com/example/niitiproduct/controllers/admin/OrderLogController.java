package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.models.OrderLog;
import com.example.niitiproduct.services.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/order_logs")
public class OrderLogController {
    @Autowired
    private OrderLogService orderLogService;

    /**
     * Get all orderLogs
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("orderLogs", orderLogs);
        return "admin/order/log/index";
    }

    /**
     * Search by orderLog name
     *
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("keyword", keyword);
        model.addAttribute("orderLogs", orderLogs);
        model.addAttribute("orderLog", new OrderLogDTO());
        return "admin/orderLog/index";
    }

    /**
     * Edit orderLog
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("orderLogs", orderLogs);
        OrderLog orderLog = orderLogService.findById(id);
        model.addAttribute("orderLog", orderLog);
        return "admin/orderLog/form";
    }

    /**
     * Update orderLog
     *
     * @param orderLog
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute OrderLog orderLog) {
        orderLogService.save(orderLog);
        return "redirect:/admin/orderLogs/edit/" + orderLog.getId();
    }

    /**
     * Add orderLog
     *
     * @param model
     * @return
     */
    @GetMapping("/orderLogs/add")
    public String add(Model model) {
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("orderLogs", orderLogs);
        return "admin/orderLog/add";
    }

    /**
     * Insert orderLog
     *
     * @param orderLog
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute OrderLog orderLog) {
        orderLogService.save(orderLog);
        return "redirect:/admin/orderLogs";
    }

    /**
     * Delete orderLog
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        orderLogService.delete(id);
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("orderLogs", orderLogs);
        model.addAttribute("orderLog", new OrderLogDTO());
        return "redirect:/admin/categories";
    }
}