package com.rusamaha.gm.model;

import javax.persistence.*;

/**
 * Created by Mary on 21.02.2015.
 */

//public enum Color {
//    BLACK,
//    BLUE,
//    GOLDEN,
//    GREEN,
//    ORANGE,
//    PINK,
//    PURPLE,
//    VIOLET,
//    WHITE,
//    YELLOW
//}
@Entity
@Table(name="COLOR")
public class Color{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COLOR_ID")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

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
}