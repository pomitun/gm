package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

/**
* Created by Mary on 21.02.2015.
*/

@Entity
@Table(name="PRODUCT_SIZE")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "PRODUCT_SIZE_ID")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JsonProperty("productBase")
    private ProductBase product;

    //@Enumerated(EnumType.STRING)
    @JsonProperty("size")
    @ManyToOne
    private Size customSize;

    @JsonManagedReference
    @OneToOne(mappedBy="productSize", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonProperty("price")
    @JsonDeserialize(contentAs = Price.class)
    @JsonSerialize(contentAs = Price.class)
    private Price price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductBase getProduct() {
        return product;
    }

    public void setProduct(ProductBase product) {
        this.product = product;
    }

    public Size getCustomSize() {
        return customSize;
    }

    public void setCustomSize(Size customSize) {
        this.customSize = customSize;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
