package org.example.candidatapi.controller;

import org.example.candidatapi.entity.Candidature;
import org.example.candidatapi.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatures")
class CandidatureController {

    @Autowired
    private CandidatureService candidatureService;

    @GetMapping
    public List<Candidature> getAllCandidatures() {
        return candidatureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidature> getCandidatureById(@PathVariable Long id) {
        Optional<Candidature> candidature = candidatureService.findById(id);
        return candidature.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Candidature createCandidature(@RequestBody Candidature candidature) {
        return candidatureService.addCandidature(candidature);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable Long id) {
        candidatureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
