package io.charoldev.msproducts.service;

import io.charoldev.msproducts.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
