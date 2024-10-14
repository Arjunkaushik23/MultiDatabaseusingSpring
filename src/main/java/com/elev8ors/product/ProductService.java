package com.elev8ors.product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    void deleteProduct(Long productId);
}