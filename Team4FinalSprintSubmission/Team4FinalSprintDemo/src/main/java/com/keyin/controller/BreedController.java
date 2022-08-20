package com.keyin.controller;

import com.keyin.entity.Breed;
import com.keyin.repository.BreedRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BreedController {
    private final BreedRepository repository;

    BreedController(BreedRepository repository){
        this.repository = repository;
    }

    @GetMapping("/breed")
    List<Breed> all(){
        return repository.findAll();
    }

    @PostMapping("/breed")
    Breed newBreed(@RequestBody Breed newBreed){
        return repository.save(newBreed);
    }

    @GetMapping("/breed/{id}")
    Optional<Breed> one(@PathVariable long id){
        return repository.findById(id);
    }

    @DeleteMapping("/breed/{id}")
    void deleteBreed(@PathVariable long id){
        repository.deleteById(id);
    }
}
