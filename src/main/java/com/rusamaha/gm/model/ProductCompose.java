package com.rusamaha.gm.model;

import javax.persistence.*;

/**
* Created by Mary on 21.02.2015.
*/
@Entity
@Table(name="PRODUCT_COMPOSE")
public class ProductCompose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_COMPOSE_ID")
    private Long id;

    @Column(name = "WEIGHT")
    private Double weight;

    @ManyToOne
    private Material material;

    @ManyToOne
    private ProductSize productSize;
}
