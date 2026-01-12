package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.dto.InvoiceResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final List<InvoiceResponseDTO> invoices = new ArrayList<>();

    public void save(InvoiceResponseDTO invoice){
        invoices.add(invoice);
    }

    public List<InvoiceResponseDTO> findAll(){
        return invoices;
    }

    public List<InvoiceResponseDTO> findByCustomerId(int customerId){
        return invoices.stream()
                .filter(invoiceResponseDTO -> invoiceResponseDTO.getCustomerId() ==customerId)
                .toList();
    }

    public InvoiceResponseDTO findById(int id){
        return invoices.stream()
                .filter(invoiceResponseDTO -> invoiceResponseDTO.getInvoiceId() ==id)
                .findFirst()
                .orElseThrow(null);
    }

}
