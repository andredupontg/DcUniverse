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
@Table(name = "charactersOrganizations")
public class CharacterInOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "characterId", referencedColumnName = "id")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Organization organization;
}
