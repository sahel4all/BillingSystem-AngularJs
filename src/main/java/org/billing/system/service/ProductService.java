package org.billing.system.service;

import org.billing.system.entity.ProductEntity;
import org.billing.system.model.Product;
import org.billing.system.repository.ProductRepository;
import org.billing.system.service.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by msahel on 8/8/2016.
 */
@Service
@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ProductsMapper productsMapper;

    public Product getProductDetails (Long id){
        ProductEntity entity=productRepository.findOne(id);
        return productsMapper.mapProductEntityToProduct(entity);
    }
}
