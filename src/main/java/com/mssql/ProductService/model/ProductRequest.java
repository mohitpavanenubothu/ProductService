package com.mssql.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
    private long id;
    private String productName;
    private long price;
    private long quantity;
}

