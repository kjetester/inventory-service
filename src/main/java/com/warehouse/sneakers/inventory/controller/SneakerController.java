package com.warehouse.sneakers.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.warehouse.sneakers.inventory.model.Sneaker;
import com.warehouse.sneakers.inventory.service.SneakerService;

import java.util.List;

@RestController
@RequestMapping("/api/sneakers")
public class SneakerController {

    @Autowired
    private SneakerService service;

    @GetMapping
    public List<Sneaker> getAllSneakers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getSneakerById(@PathVariable Long id) {
        return service.findById(id)
                .map(sneaker -> ResponseEntity.ok().body(sneaker))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sneaker createSneaker(@RequestBody Sneaker sneaker) {
        return service.save(sneaker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable Long id, @RequestBody Sneaker sneakerDetails) {
        return service.findById(id)
                .map(sneaker -> {
                    sneaker.setBrand(sneakerDetails.getBrand());
                    sneaker.setModel(sneakerDetails.getModel());
                    sneaker.setSize(sneakerDetails.getSize());
                    sneaker.setQuantity(sneakerDetails.getQuantity());
                    Sneaker updatedSneaker = service.save(sneaker);
                    return ResponseEntity.ok().body(updatedSneaker);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSneaker(@PathVariable Long id) {
        return service.findById(id)
                .map(sneaker -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}