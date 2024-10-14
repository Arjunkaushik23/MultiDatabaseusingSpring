package com.elev8ors.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @CachePut(value = "products-cache", key = "#product.productId")
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "products-cache", key = "#productId")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    @CacheEvict(value = "products-cache", key = "#productId")
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
