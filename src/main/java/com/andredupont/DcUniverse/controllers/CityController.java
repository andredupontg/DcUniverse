package com.andredupont.DcUniverse.controllers;

import com.andredupont.DcUniverse.entities.City;
import com.andredupont.DcUniverse.services.CityService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities(){
        log.info("Se está intentando obtener todas las ciudades");
        return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK);
    }

    @GetMapping(value = "/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable(name = "cityId") Integer cityId){
        log.info("Se está intentando obtener la ciudad con el id {}" + cityId);
        return new ResponseEntity<>(cityService.getCityById(cityId), HttpStatus.OK);
    }

    @GetMapping(value = "/{cityName}")
    public ResponseEntity<City> getCityByName(@PathVariable(name = "cityName") String cityName){
        log.info("Se está intentando obtener la ciudad con el nombre {}" + cityName);
        return new ResponseEntity<>(cityService.getCityByName(cityName), HttpStatus.OK);
    }

    @GetMapping(value = "/names")
    public ResponseEntity<List<City>> getAllCityNames(){
        log.info("Se está intentando obtener todos los nombres de las ciudades");
        return new ResponseEntity<>(cityService.getAllCityNames(), HttpStatus.OK);
    }

    @GetMapping(value = "/names/{cityCharacter}")
    public ResponseEntity<List<City>> getCityNamesLike(@PathVariable(name = "cityCharacter") Character cityCharacter){
        log.info("Se está intentando obtener todos los nombres de las ciudades que empiezen con la letra {}" + cityCharacter);
        return new ResponseEntity<>(cityService.getCityNamesLike(cityCharacter), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        log.info("Se está intentando crear la ciudad");
        return new ResponseEntity<>(cityService.createCity(city), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{cityId}")
    public ResponseEntity<City> updateCity(@PathVariable(value = "cityId") Integer cityId, @RequestBody City city){
        log.info("Se está intentando actualizar la ciudad");
        return new ResponseEntity<>(cityService.updateCity(cityId, city), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable(value = "cityId") Integer cityId){
        log.info("Se está intentando eliminar la ciudad");
        cityService.deleteCity(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
