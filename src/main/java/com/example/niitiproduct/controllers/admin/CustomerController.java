package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.models.Customer;
import com.example.niitiproduct.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * Get all customers
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<CustomerDTO> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "admin/customer/index";
    }

    /**
     * Search by customer name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<CustomerDTO> customers = customerService.getAll();
            model.addAttribute("customers", customers);
        } else {
            List<Customer> customers = customerService.searchByEmail(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("customers", customers);
        }
        model.addAttribute("customer", new CustomerDTO());
        return "admin/customer/index";
    }

    /**
     * Edit customer
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<CustomerDTO> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "admin/customer/form";
    }

    /**
     * Update customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/admin/customers/edit/" + customer.getId();
    }

    /**
     * Add customer
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<CustomerDTO> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "admin/customer/add";
    }

    /**
     * Insert customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/admin/customers";
    }

    /**
     * Delete customer
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        customerService.delete(id);
        List<CustomerDTO> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new CustomerDTO());
        return "redirect:/admin/customers";
    }

    /**
     * Thao tác khóa tài khoản ở màn list
     * @return
     */
    @GetMapping(value = "/inactive/{id}")
    public String inactive(Model model, @PathVariable("id") Long id) {
        System.out.println("Customer ID: " + id);
        return "redirect:/admin/customers";
    }
}