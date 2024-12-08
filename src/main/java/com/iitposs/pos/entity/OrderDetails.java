package com.iitposs.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {

    @Id
    @Column(name = "order_detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailID;


    @Column(name = "qty",nullable = false)
    private int qty;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "amount",nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item items;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;
}
