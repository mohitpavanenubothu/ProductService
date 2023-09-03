package com.mssql.ProductService.service;

import com.mssql.ProductService.model.ProductRequest;
import com.mssql.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductId(Long productId);
}
