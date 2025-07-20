package org.example.candidatapi.controller;

import org.example.candidatapi.dto.CommuneDto;
import org.example.candidatapi.entity.Commune;
import org.example.candidatapi.mapper.CommuneMapper;
import org.example.candidatapi.service.CommunesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/communes")
class CommunesController {

    private final CommunesService communesService;
    private final CommuneMapper communeMapper;

    public CommunesController(CommunesService communesService, CommuneMapper communeMapper) {
        this.communesService = communesService;
        this.communeMapper = communeMapper;
    }

    @GetMapping
    public List<CommuneDto> getAllCommunes() {
        return communesService.getAllCommunes().stream().map(communeMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommuneDto> getCommuneById(@PathVariable Long id) {
        return communesService.getCommuneById(id)
                .map(commune -> ResponseEntity.ok(communeMapper.toDto(commune))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Commune> getCommuneById(@PathVariable Long id) {
        Optional<Commune> commune = communesService.getCommuneById(id);
        return commune.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

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
