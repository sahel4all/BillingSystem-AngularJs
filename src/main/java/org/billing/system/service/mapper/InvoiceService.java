package org.billing.system.service.mapper;

import org.billing.system.entity.InvoiceEntity;
import org.billing.system.entity.ProductEntity;
import org.billing.system.model.Invoice;
import org.billing.system.repository.InvoiceRepository;
import org.billing.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by msahel on 8/8/2016.
 */
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceMapper invoiceMapper;
    @PersistenceContext
    private EntityManager em;

    public Invoice getInvoiceDetails (Long id){
       // CrudRepository c=new CrudRepository();
        InvoiceEntity entity=invoiceRepository.findOne(id);
        return invoiceMapper.mapInvoiceEntityToInvoice(entity);
    }

    public List<Invoice> getAllInvoices (){
        Iterable<InvoiceEntity> entities=invoiceRepository.findAll();
        return invoiceMapper.mapInvoiceEntitiesToInvoice(entities);
    }

    public Invoice insertInvoice( Invoice invoice){
        InvoiceEntity entity=invoiceRepository.save(invoiceMapper.mapInvoiceToInvoiceEntity(invoice));
        return invoiceMapper.mapInvoiceEntityToInvoice(entity);
    }

    public BigInteger getNextSeqVal(){
        InvoiceEntity entity;
        EntityManager manager=null;
        //System.out.println("sda:"+"select nextval("+"'"+"INVOICE_SEQUENCE"+"'");
        String query="select nextval('INVOICE_SEQUENCE')";
        Query q=em.createNativeQuery(query);
        BigInteger seqVal=(BigInteger)q.getSingleResult();
        return seqVal;
    }
}
