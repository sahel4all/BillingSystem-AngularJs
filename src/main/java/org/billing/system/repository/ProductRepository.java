package org.billing.system.repository;

import org.billing.system.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by msahel on 8/8/2016.
 */
@Repository
@Component
public interface ProductRepository extends CrudRepository<ProductEntity,Long>{

}
