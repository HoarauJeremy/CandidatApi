package org.example.candidatapi.controller;

import org.example.candidatapi.dto.CandidatureDto;
import org.example.candidatapi.entity.Candidature;
import org.example.candidatapi.mapper.CandidatureMapper;
import org.example.candidatapi.service.CandidatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidatures")
class CandidatureController {

    private final CandidatureService candidatureService;

    private final CandidatureMapper candidatureMapper;

    public CandidatureController(CandidatureService candidatureService, CandidatureMapper candidatureMapper) {
        this.candidatureService = candidatureService;
        this.candidatureMapper = candidatureMapper;
    }

    @GetMapping
    public List<CandidatureDto> getAllCandidatures() {
        return candidatureService.findAllCandidature().stream().map(candidatureMapper::toDto).collect(Collectors.toList());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Candidature> getCandidatureById(@PathVariable Long id) {
        Optional<Candidature> candidature = candidatureService.findById(id);
        return candidature.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureById(@PathVariable Long id) {
        return candidatureService.findCandidatureById(id)
                .map(candidature -> ResponseEntity.ok(candidatureMapper.toDto(candidature)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Candidature createCandidature(@RequestBody Candidature candidature) {
        return candidatureService.saveCandidature(candidature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidature> updateCandidature(@PathVariable Long id, @RequestBody Candidature candidature) {
        Optional<Candidature> candidatureOptional = candidatureService.findCandidatureById(id);
        if (candidatureOptional.isPresent()) {
            Candidature existingCandidature = candidatureOptional.get();
            candidature.setMessageMotivation(candidature.getMessageMotivation());

            candidatureService.updateCandidature(existingCandidature);
            return ResponseEntity.ok(existingCandidature);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Exemple logique : vérifier si l'utilisateur existe, puis mettre à jour
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            // sauvegarde
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable Long id) {
        candidatureService.deleteCandidature(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureById(@PathVariable Long id) {
        return candidatureService.findById(id)
                .map(candidature -> ResponseEntity.ok(candidatureMapper.toDto(candidature)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureById(@PathVariable Long id) {
        Optional<Candidature> candidatureOpt = candidatureService.findById(id);
        return candidatureOpt.map(c -> ResponseEntity.ok(mapToDto(c)))
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CandidatureDto> createCandidature(@RequestBody Candidature candidature) {
        Candidature saved = candidatureService.addCandidature(candidature);
        return ResponseEntity.ok(mapToDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable Long id) {
        candidatureService.delete(id);
        return ResponseEntity.noContent().build();
    }
    * */
}
