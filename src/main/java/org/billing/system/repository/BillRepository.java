package org.billing.system.repository;

import org.billing.system.entity.TxnDetailsEntity;
import org.billing.system.model.TxnDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by msahel on 8/24/2016.
 */
@Repository
public interface BillRepository extends CrudRepository<TxnDetailsEntity,Long> {

}
