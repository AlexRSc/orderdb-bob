package de.neuefische.java213orderdbserver.controller;

import de.neuefische.java213orderdbserver.model.Product;
import de.neuefische.java213orderdbserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) String q) {
        if(q == null || q.isBlank()){
            return productService.getAllProducts();
        }
        return productService.search(q);
    }

    @GetMapping("/{name}")
    public List<Product> searchProduct(@PathVariable String name) {
        return productService.search(name);
    }


}
