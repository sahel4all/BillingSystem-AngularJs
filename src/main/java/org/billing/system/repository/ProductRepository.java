package org.billing.system.repository;

import org.billing.system.entity.ProductEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by msahel on 8/8/2016.
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long>{

}
