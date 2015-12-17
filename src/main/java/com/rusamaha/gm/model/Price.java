package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mary on 21.02.2015.
 */

@Entity
@Table(name = "PRICES")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICES_ID")
    private Long id;

    @Column(name = "BEGIN_DATE")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @JsonProperty("beginDate")
    private Date beginDate;

    @Column(name = "END_DATE")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @JsonProperty("endDate")
    private Date endDate;

    @Column(name = "PRICE")
    @JsonProperty("price")
    private BigDecimal price;

    @OneToOne
    @JsonProperty("parentPrice")
    private Price parentPrice;

    @OneToOne
    @JsonBackReference
    private ProductSize productSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Price getParentPrice() {
        return parentPrice;
    }

    public void setParentPrice(Price parentPrice) {
        this.parentPrice = parentPrice;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }
}
