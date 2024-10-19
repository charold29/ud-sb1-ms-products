package io.charoldev.msproducts.repository;

import io.charoldev.msproducts.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
