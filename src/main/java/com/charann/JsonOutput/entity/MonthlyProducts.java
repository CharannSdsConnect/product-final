package com.charann.JsonOutput.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class MonthlyProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private double quantity;
}
