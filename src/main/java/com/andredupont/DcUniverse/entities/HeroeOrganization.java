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
@Table(name = "heroe_organization")
public class HeroeOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "heroe_id")
    private Heroe heroe;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
