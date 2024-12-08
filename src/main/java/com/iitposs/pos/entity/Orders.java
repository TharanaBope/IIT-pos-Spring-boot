package com.iitposs.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

    @Id
    @Column(name = "order_id",length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "order_total",nullable = false)
    private double orderTotal;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;
}