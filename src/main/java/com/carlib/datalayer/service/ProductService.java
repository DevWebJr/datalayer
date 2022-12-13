package com.carlib.datalayer.service;

import com.carlib.datalayer.model.Product;
import com.carlib.datalayer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * @return a list of Products
     * */
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    /**
     * @return one Product relative to its id
     * */
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    /**
     *
     * @param product
     * @return a new object of Class Product
     */
    public Product add(Product product) {
        return productRepository.save(product);
    }
}
