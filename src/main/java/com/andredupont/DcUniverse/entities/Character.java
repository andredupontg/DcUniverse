package com.andredupont.DcUniverse.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "aka")
    private String aka;

    @Column(name = "age")
    private Integer age;

    @Column(name = "profession")
    private String profession;
}
