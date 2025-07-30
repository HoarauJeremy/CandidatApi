package org.example.candidatapi.controller;

import org.example.candidatapi.dto.MetierDto;
import org.example.candidatapi.entity.Metier;
import org.example.candidatapi.mapper.MetierMapper;
import org.example.candidatapi.service.MetierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metiers")
class MetierController {

    private final MetierService metierService;
    private final MetierMapper metierMapper;

    public MetierController(MetierService metierService, MetierMapper metierMapper) {
        this.metierService = metierService;
        this.metierMapper = metierMapper;
    }

    @GetMapping
    public List<MetierDto> getMetiers() {
        return metierService.findAllMetier().stream().map(metierMapper::toDto).collect(Collectors.toList());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Metier> getMetier(@PathVariable Long id) {
        Optional<Metier> metierOptional = metierService.findById(id);
        return metierOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<MetierDto> getMetierById(@PathVariable Long id) {
        return metierService.findMetierById(id)
            .map(metier -> ResponseEntity.ok(metierMapper.toDto(metier)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Metier createMetier(@RequestBody Metier metier) {
        return metierService.saveMetier(metier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Metier> deleteMetier(@PathVariable Long id) {
        metierService.deleteMetier(id);
        return ResponseEntity.noContent().build();
    }
}
