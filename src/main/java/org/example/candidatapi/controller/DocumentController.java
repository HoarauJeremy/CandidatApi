package org.example.candidatapi.controller;

import org.example.candidatapi.entity.Document;
import org.example.candidatapi.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getDocuments() {
        return documentService.findAllDocuments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> document = documentService.findDocumentById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

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
