package org.example.candidatapi.controller;

import org.example.candidatapi.entity.OffreEmploie;
import org.example.candidatapi.service.OffreEmploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offre-emploies")
class OffreEmploieController {

    @Autowired
    private OffreEmploieService offreEmploieService;

    @GetMapping
    public List<OffreEmploie> getOffreEmploie() {
        return offreEmploieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreEmploie> getOffreEmploie(@PathVariable Long id) {
        Optional<OffreEmploie> offreEmploie = offreEmploieService.findById(id);
        return offreEmploie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OffreEmploie addOffreEmploie(@RequestBody OffreEmploie offreEmploie) {
        return offreEmploieService.save(offreEmploie);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteOffreEmploie(@PathVariable Long id) {
        offreEmploieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
