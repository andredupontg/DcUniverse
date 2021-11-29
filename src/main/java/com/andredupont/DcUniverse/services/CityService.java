package com.andredupont.DcUniverse.services;

import com.andredupont.DcUniverse.entities.City;
import com.andredupont.DcUniverse.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Integer cityId){
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("City with id %d does not exist", cityId)));
    }

    public City getCityByName(String cityName){
        return cityRepository.findByName(cityName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("City with name %s does not exist", cityName)));
    }

    public List<City> getAllCityNames(){
        return cityRepository.findNames();
    }

    public List<City> getCityNamesLike(Character cityCharacter){
        return cityRepository.findNamesLike(cityCharacter);
    }

    public City createCity(City city){
        Optional<City> result = cityRepository.findById(city.getId());
        if (!result.isPresent()){
            return cityRepository.save(city);
        } else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("City with id %d already exist", city.getId()));
        }
    }

    public City updateCity(Integer cityId, City city){
        Optional<City> result = cityRepository.findById(cityId);
        if(result.isPresent()){
            return cityRepository.save(city);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("City with id %d does not exist", cityId));
        }
    }

    public void deleteCity(Integer cityId){
        Optional<City> result = cityRepository.findById(cityId);
        if(result.isPresent()){
            cityRepository.deleteById(cityId);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("City with id %d does not exist", cityId));
        }
    }
}
