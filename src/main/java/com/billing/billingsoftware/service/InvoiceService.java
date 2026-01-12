package com.billing.billingsoftware.service;
import com.billing.billingsoftware.dto.InvoiceRequestDTO;
import com.billing.billingsoftware.dto.InvoiceResponseDTO;
import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.exception.InsufficientStockException;
import com.billing.billingsoftware.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InvoiceService {

        private final ProductService productService;
        private final CustomerService customerService;
        private final InvoiceRepository invoiceRepo;

        private int invoiceId = 1;

        public InvoiceService(ProductService productService,
                              CustomerService customerService,
                              InvoiceRepository invoiceRepo) {
            this.productService = productService;
            this.customerService = customerService;
            this.invoiceRepo = invoiceRepo;
        }

        public InvoiceResponseDTO createInvoice(InvoiceRequestDTO request) {

            if (request.getItems() == null || request.getItems().isEmpty()) {
                throw new RuntimeException("Invoice items cannot be empty");
            }

            customerService.getById(request.getCustomerId());

            InvoiceResponseDTO response = new InvoiceResponseDTO();
            response.setInvoiceId(invoiceId++);
            response.setCustomerId(request.getCustomerId());

            double total = 0;
            double taxTotal = 0;
            double discount = Math.max(request.getDiscount(), 0);

            List<InvoiceResponseDTO.ItemResponseDTO> itemResponses =
                    new ArrayList<>();

            for (InvoiceRequestDTO.ItemRequestDTO item : request.getItems()) {

                Product product = productService.getById(item.getProductId());

                if (product.getStockQuantity() < item.getQuantity()) {
                    throw new InsufficientStockException(
                            "Insufficient stock for " + product.getProductName());
                }

                double price = product.getPrice() * item.getQuantity();
                double tax = price * product.getGstPercentage() / 100;

                product.setStockQuantity(product.getStockQuantity() - item.getQuantity());

                InvoiceResponseDTO.ItemResponseDTO ir =
                        new InvoiceResponseDTO.ItemResponseDTO();

                ir.setProductName(product.getProductName());
                ir.setQuantity(item.getQuantity());
                ir.setPrice(price);
                ir.setTax(tax);
                ir.setTotal(price + tax);

                itemResponses.add(ir);

                total += price;
                taxTotal += tax;
            }

            response.setResponseDTOList(itemResponses);
            response.setTotalAmount(total);
            response.setTaxAmount(taxTotal);
            response.setDiscount(discount);
            response.setFinalAmount(total + taxTotal - discount);

            invoiceRepo.save(response);
            return response;
        }

        public List<InvoiceResponseDTO> getAllInvoices() {
            return invoiceRepo.findAll();
        }

        public InvoiceResponseDTO getInvoiceById(int id) {
            InvoiceResponseDTO invoice = invoiceRepo.findById(id);
            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }
            return invoice;
        }

        public List<InvoiceResponseDTO> getByCustomerId(int customerId) {
            return invoiceRepo.findByCustomerId(customerId);
        }
    }




