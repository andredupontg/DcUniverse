package com.andredupont.DcUniverse.services;

import com.andredupont.DcUniverse.entities.City;
import com.andredupont.DcUniverse.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City createCity(City city){
        Optional<City> result = cityRepository.findById(city.getId());
        if(!result.isPresent()){
            return cityRepository.save(city);
        } else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("The City with the id %d already exist", city.getId()));
        }
    }
}
