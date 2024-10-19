package io.charoldev.msproducts.controller;

import io.charoldev.msproducts.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductServiceImpl productService;
}
            