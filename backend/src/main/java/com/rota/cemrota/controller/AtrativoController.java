package com.rota.cemrota.controller;

import com.rota.cemrota.model.Atrativo;
import com.rota.cemrota.service.domain.AtrativoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atrativo")
public class AtrativoController {

    @Autowired
    private AtrativoService atrativoService;

    @GetMapping
    public ResponseEntity<List<Atrativo>> getAllAtrativos() {
        List<Atrativo> atrativos = atrativoService.getAllAtrativos();
        return new ResponseEntity<>(atrativos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atrativo> getAtrativoById(@PathVariable UUID id) {
        Atrativo atrativo = atrativoService.getAtrativoById(id);
        if (atrativo != null) {
            return new ResponseEntity<>(atrativo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Atrativo> createAtrativo(@RequestBody Atrativo atrativo) {
        Atrativo createdAtrativo = atrativoService.createAtrativo(atrativo);
        return new ResponseEntity<>(createdAtrativo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atrativo> updateAtrativo(@PathVariable UUID id, @RequestBody Atrativo atrativo) {
        Atrativo updatedAtrativo = atrativoService.updateAtrativo(id, atrativo);
        if (updatedAtrativo != null) {
            return new ResponseEntity<>(updatedAtrativo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtrativo(@PathVariable UUID id) {
        boolean deleted = atrativoService.deleteAtrativo(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
