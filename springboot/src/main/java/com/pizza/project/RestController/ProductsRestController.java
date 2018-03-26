package com.pizza.project.RestController;

import com.pizza.project.model.Product;
import com.pizza.project.service.ProductServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsRestController {

    private final ProductServise productServise;

    @Autowired
    public ProductsRestController(ProductServise productServise) {
        this.productServise = productServise;
    }

    //    @RequestMapping(value = "/{}" ,method = RequestMethod.GET)
//    public ResponseEntity<List<Product>> getAllPizza(){
//        List<Product> products = productServise.getProductByCategory("PIZZA");
//
//        if (products == null || products.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(products ,HttpStatus.OK);
//    }
    @CrossOrigin
    @RequestMapping(value = "/{category}" ,method = RequestMethod.GET)
    public List<Product> getAllPizza(@PathVariable("category")String category){
        List<Product> products = productServise.getProductByCategory(category);

        return products;
    }
}
