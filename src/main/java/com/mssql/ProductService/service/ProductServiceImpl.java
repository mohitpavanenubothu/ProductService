package com.mssql.ProductService.service;

import com.mssql.ProductService.entities.Product;
import com.mssql.ProductService.exception.ProductServiceCustomException;
import com.mssql.ProductService.model.ProductRequest;
import com.mssql.ProductService.model.ProductResponse;
import com.mssql.ProductService.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product
                = Product.builder()
                .productId(productRequest.getId())
                .productName(productRequest.getProductName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductId(Long productId) {
        log.info("Getting the Product based on ID::");
        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given this ID not available:", "PRODUCT_NOT_AVAILABLE"));

        //convert the product response to ProductResponse
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
