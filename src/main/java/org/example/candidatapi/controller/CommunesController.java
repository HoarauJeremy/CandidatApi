package org.example.candidatapi.controller;

import org.example.candidatapi.entity.Commune;
import org.example.candidatapi.service.CommunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/communes")
class CommunesController {

    @Autowired
    private CommunesService communesService;

    @GetMapping
    public List<Commune> getAllCommunes() {
        return communesService.getAllCommunes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commune> getCommuneById(@PathVariable Long id) {
        Optional<Commune> commune = communesService.getCommuneById(id);
        return commune.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commune addCommune(@RequestBody Commune commune) {
        return communesService.addCommune(commune);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommune(@PathVariable Long id) {
        communesService.deleteCommune(id);
        return ResponseEntity.noContent().build();
    }

}
