package com.rusamaha.gm.model;

import javax.persistence.*;

/**
* Created by Mary on 21.02.2015.
*/
@Entity
@Table(name="ORDER_PRODUCT")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_PRODUCT_ID")
    private Long id;

    @ManyToOne
    private ProductColor productColor;

    @ManyToOne
    private ProductSize productSize;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    private Order order;
}
