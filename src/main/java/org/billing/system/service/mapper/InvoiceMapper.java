package org.billing.system.service.mapper;

import org.billing.system.entity.InvoiceEntity;
import org.billing.system.entity.InvoiceEntity;
import org.billing.system.model.Invoice;
import org.billing.system.model.Invoice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msahel on 8/8/2016.
 */
@Service
public class InvoiceMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Invoice mapInvoiceEntityToInvoice(InvoiceEntity invoiceEntity){
        Invoice invoice=modelMapper.map(invoiceEntity,Invoice.class);
        return invoice;
    }

   public List<Invoice> mapInvoiceEntitiesToInvoice(Iterable<InvoiceEntity> invoiceEntities){
       List<Invoice> invoices=new ArrayList<Invoice>();
       Invoice invoice;
        for (InvoiceEntity invoiceEntity:invoiceEntities){
            invoice=modelMapper.map(invoiceEntity,Invoice.class);
            invoices.add(invoice);
        }
       return invoices;
   }

//    public Iterable<InvoiceEntity> mapProductToProductEntities(List<Invoice>){
//        List<Invoice> invoices=new ArrayList<Invoice>();
//        Invoice invoice;
//        for (InvoiceEntity invoiceEntity:invoiceEntities){
//            invoice=modelMapper.map(invoiceEntity,Invoice.class);
//            invoices.add(invoice);
//        }
//        return invoices;
//    }

    public InvoiceEntity mapInvoiceToInvoiceEntity (Invoice invoice){
        InvoiceEntity invoiceEntity= modelMapper.map(invoice,InvoiceEntity.class);
        return invoiceEntity;
    }
}
