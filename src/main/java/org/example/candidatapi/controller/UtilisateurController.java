package org.example.candidatapi.controller;

import org.example.candidatapi.dto.UtilisateurDto;
import org.example.candidatapi.dto.UtilisateurDocumentDto;
import org.example.candidatapi.mapper.UtilisateurDocumentMapper;
import org.example.candidatapi.mapper.UtilisateurMapper;
import org.example.candidatapi.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/utilisateur")
class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;
    private final UtilisateurDocumentMapper utilisateurDocumentMapper;

    public UtilisateurController(UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper, UtilisateurDocumentMapper utilisateurDocumentMapper) {
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurDocumentMapper = utilisateurDocumentMapper;
    }

    @GetMapping
    public List<UtilisateurDto> getAllUtilisateur() {
        return utilisateurService.findAll().stream().map(utilisateurMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.findUtilisateurById(id)
            .map(utilisateur -> ResponseEntity.ok(utilisateurMapper.toDto(utilisateur)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(id);
        return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }*/

    @GetMapping("/{id}/document")
    public ResponseEntity<UtilisateurDocumentDto> getUtilisateurByDocument(@PathVariable Long id) {
        return utilisateurService.findUtilisateurById(id)
            .map(utilisateurDocument -> ResponseEntity.ok(utilisateurDocumentMapper.toDto(utilisateurDocument)))
            .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
