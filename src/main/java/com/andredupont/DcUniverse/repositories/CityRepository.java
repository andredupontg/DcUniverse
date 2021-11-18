package com.andredupont.DcUniverse.repositories;

import com.andredupont.DcUniverse.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    public Optional<City> findByName(String cityName);

    @Query("SELECT c.name FROM City c")
    public List<City> findNames();

    @Query("SELECT c.name FROM City c WHERE c.name LIKE '%?1'")
    public List<City> findNamesLike(Character cityCharacter);
}
