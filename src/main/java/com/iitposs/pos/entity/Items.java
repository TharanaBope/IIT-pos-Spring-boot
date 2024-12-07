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
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int itemID;

    @Column(name = "item_name",nullable = false,length =100)
    private String name;

    @Column(name = "measuring_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasuringType measuringType;

    @Column(name="Supplier_price", nullable=false)
    private double supplierPrice;

    @Column(name="display_price",nullable=false)
    private double displayPrice;

    @Column(name="selling_price",nullable = false)
    private double sellingPrice;

    @Column(name="qty_on_hand",nullable = false)
    private int qtyOnHand;

    @Column(name="active_state",nullable = false)
    private boolean activeState;



}
