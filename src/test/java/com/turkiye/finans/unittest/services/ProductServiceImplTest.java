package com.turkiye.finans.unittest.services;

import com.turkiye.finans.unittest.dtos.ProductDetailDto;
import com.turkiye.finans.unittest.dtos.ProductForAddDto;
import com.turkiye.finans.unittest.entities.Product;
import com.turkiye.finans.unittest.repositories.ProductRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;

    ValidatorFactory validatorFactory;

    Validator validator;

    @BeforeAll
    static void baseSetup(){

    }
    @BeforeEach // => Her test öncesi ilk bu fonksiyon çalışsın.
    void setUp(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterTestClass // => class işlevini yerine getirdikten sonra
    void cleanUpAll(){
       validatorFactory.close();
    }

    // teardown,cleanup
    @AfterEach
    void cleanup(){

    }

    @Test
    void addSuccessfull(){
        ProductForAddDto request = ProductForAddDto
                .builder()
                .name("Laptop")
                .unitPrice(1500)
                .unitsInStock(10)
                .build();

        Mockito.when(productRepository.save(Mockito.any()))
                .thenReturn(Product.builder()
                        .id(1)
                        .name(request.getName())
                        .unitPrice(request.getUnitPrice())
                        .unitsInStock(request.getUnitsInStock())
                        .build());

        // Mapping Test
        ProductDetailDto response = productService.add(request);
        assert response.getId() == 1 && response.getName().equals(request.getName());

        // 11:15
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

    @Test
    void addWithBlankNameShouldThrowValidationException(){
        ProductForAddDto request = ProductForAddDto.builder()
                .name("")
                .unitsInStock(2)
                .unitPrice(10)
                .build();
        Set<ConstraintViolation<ProductForAddDto>> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
    }
}