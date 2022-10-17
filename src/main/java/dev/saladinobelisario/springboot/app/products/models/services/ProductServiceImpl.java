package dev.saladinobelisario.springboot.app.products.models.services;

import dev.saladinobelisario.springboot.app.products.models.dao.ProductDAO;
import dev.saladinobelisario.springboot.app.products.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productDAO.findAll();
    }

    @Override
    public Product findByID(Long id) {
        return productDAO.findById(id).orElse(null);
    }
}
