package com.iitposs.pos.service;


import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDTO;
import com.iitposs.pos.dto.response.CustomerResposeDTO;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO saveRequestDTO);

    CustomerResposeDTO getCustomerById(int customerId);

    List<CustomerResposeDTO> getAllCustomers();

    String deleteCustomer(int customerID);

    List<CustomerAllDetailsResponseDTO> getAllCustomerByState(boolean state);
}
