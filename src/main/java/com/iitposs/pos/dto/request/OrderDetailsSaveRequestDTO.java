package com.iitposs.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsSaveRequestDTO {

    private String itemName;
    private int qty;
    private double amount;
    private int item_id;
}
