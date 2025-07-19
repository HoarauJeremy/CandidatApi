package org.example.candidatapi.controller;

import org.example.candidatapi.entity.Metier;
import org.example.candidatapi.service.MetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metiers")
class MetierController {

    @Autowired
    private MetierService metierService;

    @GetMapping
    public List<Metier> getMetiers() {
        return metierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metier> getMetier(@PathVariable Long id) {
        Optional<Metier> metierOptional = metierService.findById(id);
        return metierOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Metier createMetier(@RequestBody Metier metier) {
        return metierService.save(metier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Metier> deleteMetier(@PathVariable Long id) {
        metierService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
