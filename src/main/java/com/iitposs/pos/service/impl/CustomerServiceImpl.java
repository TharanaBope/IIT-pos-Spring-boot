package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDTO;
import com.iitposs.pos.dto.response.CustomerResposeDTO;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.repo.CustomerRepo;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                saveRequestDTO.getCustomerID(),
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getCustomerAddress(),
                saveRequestDTO.getSalary(),
                saveRequestDTO.getContacts(),
                saveRequestDTO.getNic(),
                saveRequestDTO.isActiveSate()
        );

        customerRepo.save(customer);
        return "Customer saved successfully";
    }

    @Override
    public String updateCustomer(CustomerSaveRequestDTO saveRequestDTO) {
        if(customerRepo.existsById(saveRequestDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(saveRequestDTO.getCustomerID());

            customer.setCustomerName(saveRequestDTO.getCustomerName());
            customer.setCustomerAddress(saveRequestDTO.getCustomerAddress());
            customer.setSalary(saveRequestDTO.getSalary());
            customer.setActiveSate(saveRequestDTO.isActiveSate());

            customerRepo.save(customer);

            return saveRequestDTO.getCustomerName()+" updated successfully";
        }else{
return "Customer not found";
        }
    }

    @Override
    public CustomerResposeDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);

            CustomerResposeDTO resposeDTO = new CustomerResposeDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveSate()
            );

            return resposeDTO;
    }else{
            return null;
        }
    }

    @Override
    public List<CustomerResposeDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();

        List<CustomerResposeDTO> responseDTOs = new ArrayList<>();

        for(Customer customer: customers) {

            responseDTOs.add(new CustomerResposeDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveSate()
            ));
        }
        return responseDTOs;
    }

    @Override
    public String deleteCustomer(int customerID) {
        if(customerRepo.existsById(customerID)){
            customerRepo.deleteById(customerID);
            return customerID+" customer deleted successfully";
        }else{
            return "Customer not found";
        }
    }

    @Override
    public List<CustomerAllDetailsResponseDTO> getAllCustomerByState(boolean state) {
        List<Customer> customers = customerRepo.findAllByActiveSateEquals(state);

        List<CustomerAllDetailsResponseDTO> responseDTOs = new ArrayList<>();

        for(Customer customer: customers) {

            responseDTOs.add(new CustomerAllDetailsResponseDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveSate()
            ));
        }
        return responseDTOs;
    }
}
