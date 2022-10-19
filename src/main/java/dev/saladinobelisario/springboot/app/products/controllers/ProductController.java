package dev.saladinobelisario.springboot.app.products.controllers;

import dev.saladinobelisario.springboot.app.products.models.entity.Product;
import dev.saladinobelisario.springboot.app.products.models.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private Environment env;
    @Value("${PORT:0}")
    private Integer port;
    @Autowired
    private IProductService productService;

    @GetMapping("/listar")
    public List<Product> listProducts(){
        return productService.findAll().stream()
                .map(product -> {
                    product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    //product.setPort(port);
                    return product;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/producto/{id}")
    public Product detail(@PathVariable Long id){
        Product product = productService.findByID(id);
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        //product.setPort(port);


		 /* try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

        return product;
    }
}
