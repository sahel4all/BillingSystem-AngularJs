package org.billing.system.service.mapper;

import org.billing.system.entity.TxnDetailsEntity;
import org.billing.system.model.TxnDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TxnDetailsEntity> mapTxnDetailListToTxnDetailEntity(List<TxnDetails> txnDetails){
        List<TxnDetailsEntity> txnDetailsEntityList=new ArrayList<org.billing.system.entity.TxnDetailsEntity>();
        for (TxnDetails txnDetail:txnDetails){
            TxnDetailsEntity txnDetailsEntity=mapper.map(txnDetail,TxnDetailsEntity.class);
            txnDetailsEntityList.add(txnDetailsEntity);
        }
        //TxnDetailsEntity txnDetailsEntity=mapper.map(txnDetails,TxnDetailsEntity.class);
        return txnDetailsEntityList;
    }

    public TxnDetails mapTxnDetailToEntityTxnDetail(TxnDetailsEntity txnDetailsEntity){
        TxnDetails txnDetails=mapper.map(txnDetailsEntity,TxnDetails.class);
        return txnDetails;
    }

    public List<TxnDetails> mapTxnDetailListToEntityTxnDetail(List<TxnDetailsEntity> txnDetailsEntity){
        List<TxnDetails> txnDetailsList=new ArrayList<TxnDetails>();
        for (TxnDetailsEntity txnDetailsEnt:txnDetailsEntity){
            TxnDetails txnDetails=mapper.map(txnDetailsEnt,TxnDetails.class);
            txnDetailsList.add(txnDetails);
        }
        return txnDetailsList;
    }
}

