package com.andredupont.DcUniverse.repositories;

import com.andredupont.DcUniverse.entities.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer> {
}
