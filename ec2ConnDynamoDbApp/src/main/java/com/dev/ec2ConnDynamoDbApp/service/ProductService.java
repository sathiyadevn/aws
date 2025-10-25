package com.dev.ec2ConnDynamoDbApp.service;

import com.dev.ec2ConnDynamoDbApp.entity.Product;
import com.dev.ec2ConnDynamoDbApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product getProduct(String id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product updateProduct(Product product) {
        return repository.save(product); // DynamoDB putItem replaces existing
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
