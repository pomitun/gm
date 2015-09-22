package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

/**
* Created by Mary on 21.02.2015.
*/
@Entity
@Table(name="ORDER_TOTAL")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_TOTAL_ID")
    private Long id;

    @ManyToOne
    private User customer;

    @Column(name = "TOTAL_COST")
    private Integer totalCost;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Past
    @Column(name = "CREATE_DATE")
    private Date date;

    @ManyToOne
    private User master;

}
