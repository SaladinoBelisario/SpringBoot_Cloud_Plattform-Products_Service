package dev.saladinobelisario.springboot.app.products.models.dao;

import dev.saladinobelisario.springboot.app.products.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {

}
