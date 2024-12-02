package com.iitposs.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="customer")
@TypeDef(name="json",typeClass = JsonType.class)
// have to put the lombok dependenicy for the below to work , and the to string method has a anotation as well
@NoArgsConstructor  // when you put this there is no need of the defualt constructor
@AllArgsConstructor // when you put this there is no neeed for the parameterized constructor
@Data // when you put this there is no need to put the getters and setters
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id",length=10)
    private int customerID;

    @Column(name="customer_name",length=100,nullable = false)
    private String customerName;

    @Column(name="customer_address")
    private String customerAddress;

    @Column(name = "salary",nullable = false)
    private double salary;

    @Type(type = "json")
    @Column(name="contacts",columnDefinition = "json")
    private ArrayList contacts;

    @Column(name="nic",nullable = false)
    private String nic;

    @Column(name="active_state",columnDefinition = "TINYINT default 1")
    private boolean activeSate;


}
