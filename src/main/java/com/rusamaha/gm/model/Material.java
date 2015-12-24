package com.rusamaha.gm.model;

import javax.persistence.*;

/**
* Created by Mary on 21.02.2015.
*/

@Entity
@Table(name="MATERIAL")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MATERIAL_ID")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;
}
