package com.template.presentation.controller;

import com.template.business.services.MeteorologicalService;
import com.template.data.entity.MeteorologicalEntity;
import com.template.data.entity.TutorialEntity;
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

    @PostMapping("/meteorological/post")
    public ResponseEntity<MeteorologicalEntity> posteteorological(@RequestBody MeteorologicalEntity meteorologicalRequest) {
        try {
            MeteorologicalEntity meteorologicalPost = meteorologicalService.create(meteorologicalRequest);
            return new ResponseEntity<>(meteorologicalPost, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/meteorological/get")
    public ResponseEntity<List<MeteorologicalEntity>> findALL(@RequestParam(required = false) String city){
        try{
            List<MeteorologicalEntity> meteorological = meteorologicalService.getAll(city);

            if(meteorological.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(meteorological, HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/meteorological/get/city/{city}")
    public ResponseEntity<List<MeteorologicalEntity>> findByCity(@PathVariable String city){
        try{
            List<MeteorologicalEntity> meteorological = meteorologicalService.getAll(city);
            return new ResponseEntity<>(meteorological, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/meteorological/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMeteorological(@PathVariable("id") long id) {
        try {
            meteorologicalService.deleteMeteorological(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
