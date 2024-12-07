package com.iitposs.pos.dto.response;

import com.iitposs.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemResponseDTO {
    private int itemID;
    private String name;
    private MeasuringType measuringType;
    private double supplierPrice;
    private double displayPrice;
    private double sellingPrice;
    private int qtyOnHand;
    private boolean activeState;
}
