package io.charoldev.msproducts.service;

import io.charoldev.msproducts.model.Product;
import io.charoldev.msproducts.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    public static final String SERVER_PORT = "local.server.port";
    private final IProductRepository productRepository;
    private final Environment environment;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>) productRepository.findAll()).stream().peek((Product product) -> product.setPort(
                Integer.parseInt(Objects.requireNonNull(environment.getProperty(SERVER_PORT)))
        )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map((Product product) -> {
            product.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty(SERVER_PORT))));
            return product;
        });
    }
}
