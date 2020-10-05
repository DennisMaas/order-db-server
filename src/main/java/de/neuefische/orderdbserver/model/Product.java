package de.neuefische.orderdbserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;
    private String id;
    private int price;
    private int weight;
}