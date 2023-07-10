package com.boa.customerapi.models;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="Customer")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    @Id
    private long customerId;
    @Embedded
    private FullName name;
    @Column(name="Contact_No")
    private long contactNo;
    @Column(name="Email",nullable = false,length = 150)
    private String email;
    @Column(name="Password",nullable = false,length = 10)
    private String password;
    
    

}
