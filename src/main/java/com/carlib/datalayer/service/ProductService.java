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

    public Iterable<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> getProductsByCategoryName(String name) {
        return productRepository.findByCategoriesName(name);
    }


    /**
     *
     * @param product
     * @return a new object of Class Product
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id){ productRepository.deleteById(id); }
}
