package dev.saladinobelisario.springboot.app.products.models.services;

import dev.saladinobelisario.springboot.app.products.models.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findByID(Long id);
}
