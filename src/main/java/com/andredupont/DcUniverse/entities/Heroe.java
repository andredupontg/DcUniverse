package com.andredupont.DcUniverse.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "heroe")
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "abilities", nullable = false)
    private List<String> abilities;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = true)
    private Person person;
}
