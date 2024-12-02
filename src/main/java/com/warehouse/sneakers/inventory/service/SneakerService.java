package com.warehouse.sneakers.inventory.service;

import com.warehouse.sneakers.inventory.model.Sneaker;
import com.warehouse.sneakers.inventory.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SneakerService {

    @Autowired
    private SneakerRepository repository;

    public List<Sneaker> findAll() {
        return repository.findAll();
    }

    public Optional<Sneaker> findById(Long id) {
        return repository.findById(id);
    }

    public Sneaker save(Sneaker sneaker) {
        return repository.save(sneaker);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
