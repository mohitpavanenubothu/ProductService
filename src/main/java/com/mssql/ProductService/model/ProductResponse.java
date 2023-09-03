package com.mssql.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private long productId;
    private String productName;
    private long price;
    private long quantity;
}
