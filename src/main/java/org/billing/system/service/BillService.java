package org.billing.system.service;

import org.billing.system.entity.TxnDetailsEntity;
import org.billing.system.model.TxnDetails;
import org.billing.system.repository.BillRepository;
import org.billing.system.service.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by msahel on 8/24/2016.
 */
@Service
public class BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    BillMapper billMapper;

    public TxnDetails insertTxnDetails (TxnDetails txnDetails){
        TxnDetailsEntity txnDetailsEntity= billMapper.mapTxnDetailToTxnDetailEntity(txnDetails);
        return billMapper.mapTxnDetailToEntityTxnDetail(billRepository.save( txnDetailsEntity)) ;
    }
}
