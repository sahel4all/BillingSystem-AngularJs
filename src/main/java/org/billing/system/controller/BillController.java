package org.billing.system.controller;

import org.billing.system.model.TxnDetails;
import org.billing.system.repository.BillRepository;
import org.billing.system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by msahel on 8/22/2016.
 */
@RestController
public class BillController {

    @Autowired
    BillService billService;

    @RequestMapping(value="/bill",method= RequestMethod.PUT)
    public ResponseEntity generateBill(@RequestBody TxnDetails txnDetails){
        TxnDetails txnDetailsNew =billService.insertTxnDetails( txnDetails);
        return new ResponseEntity(txnDetailsNew, HttpStatus.OK);
    }
}
