package com.midnightsun.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_seq_gen", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String username;
}
