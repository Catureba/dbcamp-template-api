package com.template.presentation.controller;

import com.template.business.services.MeteorologicalService;
import com.template.data.entity.MeteorologicalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4767")
@RestController
@RequestMapping("/api")
public class MeteorologicalController {
    @Autowired
    MeteorologicalService meteorologicalService;

    @GetMapping("/meteorologicals")
    public ResponseEntity<List<MeteorologicalEntity>> findAllMeteorological(@RequestParam(required = false)String city){
        try{
            List<MeteorologicalEntity> meteorological = meteorologicalService.getAll(city);
            if(meteorological.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(meteorological, HttpStatus.OK);
            }
        } catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/meteorologicals/{city}")
    public ResponseEntity<List<MeteorologicalEntity>> findMeteorologicalByCity(@PathVariable("city") String city){
        try{
            List<MeteorologicalEntity> meteorological = meteorologicalService.findByCity(city);
            if(meteorological.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(meteorological, HttpStatus.OK);
            }
        } catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/meteorologicals")
    public ResponseEntity<MeteorologicalEntity> postMeteorological(@RequestBody MeteorologicalEntity meteorologicalRequest) {
        try {
            MeteorologicalEntity meteorologicalPost = meteorologicalService.create(meteorologicalRequest);
            return new ResponseEntity<>(meteorologicalPost, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
