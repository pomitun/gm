package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

/**
* Created by Mary on 21.02.2015.
*/

@Entity
@Table(name="PRICES")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICES_ID")
    private Long id;

    @Column(name = "BEGIN_DATE")
    @JsonFormat(pattern="MM/dd/yyyy")
    @JsonProperty("beginDate")
    private Date beginDate;

    @Column(name = "END_DATE")
    @JsonFormat(pattern="MM/dd/yyyy")
    @JsonProperty("endDate")
    private Date endDate;

    @Column(name = "PRICE")
    private BigDecimal price;

    @OneToOne
    private Price parentPrice;

    @OneToOne
    @JsonBackReference
    private ProductSize productSize;
}
