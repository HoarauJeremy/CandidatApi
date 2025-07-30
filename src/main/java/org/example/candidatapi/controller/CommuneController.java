package org.example.candidatapi.controller;

import org.example.candidatapi.dto.CommuneDto;
import org.example.candidatapi.entity.Commune;
import org.example.candidatapi.mapper.CommuneMapper;
import org.example.candidatapi.service.CommuneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/communes")
class CommuneController {

    private final CommuneService communeService;
    private final CommuneMapper communeMapper;

    public CommuneController(CommuneService communeService, CommuneMapper communeMapper) {
        this.communeService = communeService;
        this.communeMapper = communeMapper;
    }

    @GetMapping
    public List<CommuneDto> getAllCommunes() {
        return communeService.findAllCommunes().stream().map(communeMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommuneDto> getCommuneById(@PathVariable Long id) {
        return communeService.findCommuneById(id)
                .map(commune -> ResponseEntity.ok(communeMapper.toDto(commune))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Commune> getCommuneById(@PathVariable Long id) {
        Optional<Commune> commune = communesService.getCommuneById(id);
        return commune.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @PostMapping
    public Commune addCommune(@RequestBody Commune commune) {
        return communeService.saveCommune(commune);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommune(@PathVariable Long id) {
        communeService.deleteCommune(id);
        return ResponseEntity.noContent().build();
    }

}
