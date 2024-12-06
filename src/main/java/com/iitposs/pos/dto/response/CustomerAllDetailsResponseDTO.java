package com.iitposs.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerAllDetailsResponseDTO {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private double salary;
    private ArrayList contacts;
    private String nic;
    private boolean activeSate;
}
