package org.example.candidatapi.controller;

import org.example.candidatapi.dto.DocumentDto;
import org.example.candidatapi.entity.Document;
import org.example.candidatapi.mapper.DocumentMapper;
import org.example.candidatapi.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/documents")
class DocumentController {

    private final DocumentService documentService;
    private final DocumentMapper documentMapper;

    public DocumentController(DocumentService documentService, DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
    }

    @GetMapping
    public List<DocumentDto> getDocuments() {
        return documentService.findAllDocuments().stream().map(documentMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {
        return documentService.findDocumentById(id)
                .map(document -> ResponseEntity.ok(documentMapper.toDto(document))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> document = documentService.findDocumentById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocumentById(id);
        return ResponseEntity.noContent().build();
    }
}
