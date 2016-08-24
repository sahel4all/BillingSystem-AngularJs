package org.billing.system.service.mapper;

import org.billing.system.entity.TxnDetailsEntity;
import org.billing.system.model.TxnDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by msahel on 8/24/2016.
 */
@Service
public class BillMapper  {
    @Autowired
    private ModelMapper mapper;
    public TxnDetailsEntity mapTxnDetailToTxnDetailEntity(TxnDetails txnDetails){
        TxnDetailsEntity txnDetailsEntity=mapper.map(txnDetails,TxnDetailsEntity.class);
        return txnDetailsEntity;
    }

    public TxnDetails mapTxnDetailToEntityTxnDetail(TxnDetailsEntity txnDetailsEntity){
        TxnDetails txnDetails=mapper.map(txnDetailsEntity,TxnDetails.class);
        return txnDetails;
    }
}

