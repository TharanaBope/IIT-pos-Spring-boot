package com.iitposs.pos.entity;

import com.iitposs.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "measuring_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasuringType measuringType;

    @Column(name = "supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name = "display_price", nullable = false)
    private double displayPrice;

    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "qty_on_hand", nullable = false)
    private int qtyOnHand;

    @Column(name = "active_state", nullable = false)
    private boolean activeState;

    public Item(String name,
                MeasuringType measuringType,
                double supplierPrice,
                double displayPrice,
                double sellingPrice,
                int qtyOnHand,
                boolean activeState) {
        this.name = name;
        this.measuringType = measuringType;
        this.supplierPrice = supplierPrice;
        this.displayPrice = displayPrice;
        this.sellingPrice = sellingPrice;
        this.qtyOnHand = qtyOnHand;
        this.activeState = activeState;
    }
}