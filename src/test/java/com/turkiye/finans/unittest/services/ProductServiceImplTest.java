package com.turkiye.finans.unittest.services;

import com.turkiye.finans.unittest.dtos.ProductForAddDto;
import com.turkiye.finans.unittest.entities.Product;
import com.turkiye.finans.unittest.repositories.ProductRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;

    @BeforeAll
    static void baseSetup(){

    }
    @BeforeEach // => Her test öncesi ilk bu fonksiyon çalışsın.
    void setUp(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    @AfterAll
    static void cleanUpAll(){

    }

    // teardown,cleanup
    @AfterEach
    void cleanup(){

    }

    @Test
    void addSuccessfull(){
        assert true;
    }
    @Test
    void addWithSameNameShouldThrowException() {
        // 3A Principle => 3A Prensipi
        // Arrange,Act,Assert

        // Arrange => Testini yapacağımız senaryonun bağımlılıklarının çözülmesi.
        // ProductRepository bağımlılığı gibi
        // Mock?

        // Act => Mevcut senaryo için verilerin oluşturulması,
        // İlgili kodların çağırılması ve karşılığında beklenen durumun belirtilmesi.

        // Assert => Expected durum ile act kısmında elde edilen durumun karşılaştırıldığı nokta.

        // Arrange
        // Mock
        // Testin DB'den bağımsız olması..

        // Arrange

        // Act
        // Repositorynin hali hazırda bu isimde bir veriye sahip olduğu senaryo..

        // when-then
        Product product = Product.builder().name("Laptop").unitPrice(1500).unitsInStock(15).build();
        Mockito.when(productRepository.findByName("Laptop"))
                .thenReturn(Optional.of(product));

        // ProductRepository.findByName("laptop") => Product classı
        ProductForAddDto request = ProductForAddDto
                .builder()
                .name("Laptop")
                .unitPrice(1500)
                .unitsInStock(10)
                .build();
        // Act
        // Assert
        assertThrows(RuntimeException.class, () -> {
            productService.add(request);
        });
    }
}