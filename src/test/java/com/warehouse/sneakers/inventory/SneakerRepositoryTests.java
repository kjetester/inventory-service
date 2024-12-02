package com.warehouse.sneakers.inventory;

import com.warehouse.sneakers.inventory.model.Sneaker;
import com.warehouse.sneakers.inventory.repository.SneakerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SneakerRepositoryTests {

    @Autowired
    private SneakerRepository sneakerRepository;

    @Test
    void testSaveAndFind() {
        Sneaker sneaker = new Sneaker();
        sneaker.setBrand("Nike");
        sneaker.setModel("Air Max");
        sneaker.setSize(42);
        sneaker.setQuantity(10);

        sneakerRepository.save(sneaker);

        List<Sneaker> sneakers = sneakerRepository.findAll();
        assertThat(sneakers).hasSize(1);
        assertThat(sneakers.get(0).getBrand()).isEqualTo("Nike");
        assertThat(sneakers.get(0).getModel()).isEqualTo("Air Max");
        assertThat(sneakers.get(0).getSize()).isEqualTo(42);
        assertThat(sneakers.get(0).getQuantity()).isEqualTo(10);
    }
}