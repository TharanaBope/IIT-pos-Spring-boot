package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDTO;
import com.iitposs.pos.dto.response.CustomerResposeDTO;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get-customer-customerId", params = "id")
    public CustomerResposeDTO getCustomer(@RequestParam (value = "id") int customerId){

        CustomerResposeDTO resposeDTO = customerService.getCustomerById(customerId);
        return resposeDTO;
    }

    @GetMapping(path = "get-all-customers")
    public List<CustomerResposeDTO> getAllCustomers(){
        List<CustomerResposeDTO> dtoList = customerService.getAllCustomers();
        return dtoList;
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable (value = "id") int customerID){
        String message = customerService.deleteCustomer(customerID);
        return message;
    }

    @GetMapping(path = "/get-all-customer-bt-sate", params = "state")
    public List<CustomerAllDetailsResponseDTO> getCustomeByState(@RequestParam (value = "state") boolean state){
        List<CustomerAllDetailsResponseDTO> dtoList = customerService.getAllCustomerByState(state);
        return dtoList;
    }


}
