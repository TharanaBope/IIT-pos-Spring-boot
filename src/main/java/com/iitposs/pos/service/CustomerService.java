package com.iitposs.pos.service;


import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;

public interface CustomerService {

    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO saveRequestDTO);
}
