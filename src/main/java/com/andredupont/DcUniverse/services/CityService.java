package com.andredupont.DcUniverse.services;

import com.andredupont.DcUniverse.entities.City;
import com.andredupont.DcUniverse.repositories.CityRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        log.info("Se obtuvieron todas las ciudades");
        return cityRepository.findAll();
    }

    public City getCityById(Integer cityId){
        return cityRepository.findById(cityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("City with id %d does not exist", cityId)));
    }

    public City createCity(City city){
        Optional<City> result = cityRepository.findById(city.getId());
        if (!result.isPresent()){
            log.info("Se registró la ciudad");
            return cityRepository.save(city);
        } else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("City with id %d already exist", city.getId()));
        }
    }
}
