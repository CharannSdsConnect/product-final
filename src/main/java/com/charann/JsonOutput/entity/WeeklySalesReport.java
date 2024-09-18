package com.charann.JsonOutput.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeeklySalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
