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

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        log.info("Se está intentando crear la ciudad");
        return new ResponseEntity<>(cityService.createCity(city), HttpStatus.CREATED);
    }
}
