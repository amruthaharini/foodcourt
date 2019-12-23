package com.example.foodcourt.appetizers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/appetizers")
public class AppetizerController {

    private AppetizerRepository appetizersRepository;

    public AppetizerController(AppetizerRepository appetizersRepository) {
        this.appetizersRepository = appetizersRepository;
    }

    @PostMapping
    public ResponseEntity<Appetizer> create(@RequestBody Appetizer appetizer) {

        appetizersRepository.save(appetizer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Appetizer> getAll() {
        List<Appetizer> appetizers = new ArrayList<>();
        appetizersRepository.findAll().forEach(appetizers::add);
        return appetizers;
    }
}