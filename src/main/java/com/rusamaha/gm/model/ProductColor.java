package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mary on 21.02.2015.
 */
@Entity
@Table(name="PRODUCT_COLOR")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "PRODUCT_COLOR_ID")
    private Long id;

    @JsonProperty("image")
    @Column(name = "IMAGE")
    private String image;

    @ManyToOne
    @JsonBackReference
    @JsonProperty("productBase")
    private ProductBase product;


    //@Enumerated(EnumType.STRING)
    @JsonProperty("color")
    @ManyToOne
    private Color color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductBase getProduct() {
        return product;
    }

    public void setProduct(ProductBase product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
