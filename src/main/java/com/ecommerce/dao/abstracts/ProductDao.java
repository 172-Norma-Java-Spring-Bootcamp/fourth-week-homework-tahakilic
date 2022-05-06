package com.ecommerce.dao.abstracts;

import com.ecommerce.entity.ProductEntity;

public interface ProductDao {
    ProductEntity createProduct(ProductEntity productEntity);
}
