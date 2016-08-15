package org.billing.system.controller;

import org.billing.system.model.Product;
import org.billing.system.repository.ProductRepository;
import org.billing.system.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by msahel on 8/7/2016.
 */
@RestController
@Component
public class ProductController {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/product/1",method = RequestMethod.GET)
    //public ResponseEntity getProducts(@PathVariable final long id){
    public ResponseEntity getProducts(){
        try{
            System.out.println("From Controller");
            Product product=productService.getProductDetails(Long.valueOf("1"));
            return new ResponseEntity(product,HttpStatus.OK);
        }
        catch(Exception e){
            //LOGGER.error(" Error occurred while fetching patient id {} : {} ",id, e.getMessage());
            return new ResponseEntity("No product found:", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> getAllProducts(){
        List<Product> products=productService.getAllProducts();
        return products;
    }
}
