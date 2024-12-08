package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.OrderSaveRequestDTO;
import com.iitposs.pos.service.OrderService;
import com.iitposs.pos.util.enums.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-order")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        String message = orderService.saveOrder(orderSaveRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
    }

}

