package org.billing.system.service;

import org.billing.system.entity.ProductEntity;
import org.billing.system.model.Product;
import org.billing.system.repository.ProductRepository;
import org.billing.system.service.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by msahel on 8/8/2016.
 */
@Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ProductsMapper productsMapper;

    public Product getProductDetails (Long id){
       // CrudRepository c=new CrudRepository();
        ProductEntity entity=productRepository.findOne(id);
        return productsMapper.mapProductEntityToProduct(entity);
    }

    public List<Product> getAllProducts (){
        Iterable<ProductEntity> entities=productRepository.findAll();
        return productsMapper.mapProductEntitiesToProduct(entities);
    }

    public Product insertProduct( Product product){
        ProductEntity entity=productRepository.save(productsMapper.mapProductToProductEntity(product));
        return productsMapper.mapProductEntityToProduct(entity);
    }
}
