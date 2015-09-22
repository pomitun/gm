package com.rusamaha.gm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mary on 21.02.2015.
 */
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "ProductBase.saveProduct"
                , procedureName = "PRODUCT_INS"
                , resultClasses = ProductBase.class
                , parameters = {
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "NAME", type = String.class) ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "KNIT_TECHNOLOGY", type = String.class),
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "CATEGORY_CATEGORY_ID", type = Long.class),
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "AVAILABILITY", type = Boolean.class)
                    //, @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID", type = Long.class)
                }
        )
})

@Entity
@Table(name="PRODUCT_BASE")
public class ProductBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "PRODUCT_BASE_ID")
    private Long id;

    @JsonProperty("name")
    @Column(name = "NAME", length = 100)
    private String name;

    @JsonProperty("availability")
    @Column(name = "AVAILABILITY", length = 100)
    private Boolean availability;

    @JsonProperty("knitTechnology")
    @Column(name = "KNIT_TECHNOLOGY", length = 100)
    private String knitTechnology;

    @ManyToOne
    @JsonProperty("category")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy="product", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonProperty("productSizes")
    @JsonDeserialize(contentAs = ProductSize.class)
    @JsonSerialize(contentAs = ProductSize.class)
    private List<ProductSize> productSizes;

    @JsonManagedReference
    @OneToMany(mappedBy="product", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonProperty("productColors")
    @JsonDeserialize(contentAs = ProductColor.class)
    @JsonSerialize(contentAs = ProductColor.class)
    private List<ProductColor> productColors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getKnitTechnology() {
        return knitTechnology;
    }

    public void setKnitTechnology(String knitTechnology) {
        this.knitTechnology = knitTechnology;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }
}
