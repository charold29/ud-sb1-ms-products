package io.charoldev.msproducts.service;

import io.charoldev.msproducts.model.Product;
import io.charoldev.msproducts.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final IProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
