package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path="/save-customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){

        String message = customerService.saveCustomer(saveRequestDTO);

        return message;
    }

    @PutMapping(path="/update-customer")
    public String updateCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){

        String message = customerService.updateCustomer(saveRequestDTO);

        return message;
    }

    //@GetMapping
}
