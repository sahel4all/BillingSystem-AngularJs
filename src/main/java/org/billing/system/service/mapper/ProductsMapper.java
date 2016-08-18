package org.billing.system.service.mapper;

import org.billing.system.entity.ProductEntity;
import org.billing.system.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msahel on 8/8/2016.
 */
@Service
public class ProductsMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Product mapProductEntityToProduct(ProductEntity productEntity){
        Product product=modelMapper.map(productEntity,Product.class);
        return product;
    }

   public List<Product> mapProductEntitiesToProduct(Iterable<ProductEntity> productEntities){
       List<Product> products=new ArrayList<Product>();
       Product product;
        for (ProductEntity productEntity:productEntities){
            product=modelMapper.map(productEntity,Product.class);
            products.add(product);
        }
       return products;
   }

//    public Iterable<ProductEntity> mapProductToProductEntities(List<Product>){
//        List<Product> products=new ArrayList<Product>();
//        Product product;
//        for (ProductEntity productEntity:productEntities){
//            product=modelMapper.map(productEntity,Product.class);
//            products.add(product);
//        }
//        return products;
//    }

    public ProductEntity mapProductToProductEntity (Product product){
        ProductEntity productEntity= modelMapper.map(product,ProductEntity.class);
        return productEntity;
    }
}
