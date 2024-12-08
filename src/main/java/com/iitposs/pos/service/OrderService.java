package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String saveOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}