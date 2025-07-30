package org.example.candidatapi.controller;

import org.example.candidatapi.dto.OffreEmploieDto;
import org.example.candidatapi.entity.OffreEmploie;
import org.example.candidatapi.mapper.OffreEmploieMapper;
import org.example.candidatapi.service.OffreEmploieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offre-emploies")
class OffreEmploieController {

    private final OffreEmploieService offreEmploieService;
    private final OffreEmploieMapper offreEmploieMapper;

    public OffreEmploieController(OffreEmploieService offreEmploieService, OffreEmploieMapper offreEmploieMapper) {
        this.offreEmploieService = offreEmploieService;
        this.offreEmploieMapper = offreEmploieMapper;
    }

    @GetMapping
    public List<OffreEmploieDto> getOffreEmploie() {
        return offreEmploieService.findAllOffreEmploie().stream().map(offreEmploieMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreEmploieDto> getOffreEmploie(@PathVariable Long id) {
        return offreEmploieService.findOffreEmploieById(id)
                .map(offreEmploie -> ResponseEntity.ok(offreEmploieMapper.toDto(offreEmploie))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<OffreEmploie> getOffreEmploie(@PathVariable Long id) {
        Optional<OffreEmploie> offreEmploie = offreEmploieService.findById(id);
        return offreEmploie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @PostMapping
    public OffreEmploie addOffreEmploie(@RequestBody OffreEmploie offreEmploie) {
        return offreEmploieService.saveOffreEmploie(offreEmploie);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteOffreEmploie(@PathVariable Long id) {
        offreEmploieService.deleteOffreEmploie(id);
        return ResponseEntity.noContent().build();
    }
}
