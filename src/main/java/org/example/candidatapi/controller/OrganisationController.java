package org.example.candidatapi.controller;

import org.example.candidatapi.dto.OrganisationDto;
import org.example.candidatapi.entity.Organisation;
import org.example.candidatapi.mapper.OrganisationMapper;
import org.example.candidatapi.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organisations")
class OrganisationController {

    private final OrganisationService organisationService;
    private final OrganisationMapper organisationMapper;

    public OrganisationController(OrganisationService organisationService, OrganisationMapper organisationMapper) {
        this.organisationService = organisationService;
        this.organisationMapper = organisationMapper;
    }

    @GetMapping
    public List<OrganisationDto> getAll() {
        return organisationService.getAllOrganisations().stream().map(organisationMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganisationDto> getOrganisationById(@PathVariable Long id) {
        return organisationService.getOrganisationById(id).map(organisation -> ResponseEntity.ok(organisationMapper.toDto(organisation))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organisation addOrganisation(@RequestBody Organisation organisation) {
        return organisationService.saveOrganisation(organisation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        organisationService.deleteOrganisation(id);
        return ResponseEntity.noContent().build();
    }
}
