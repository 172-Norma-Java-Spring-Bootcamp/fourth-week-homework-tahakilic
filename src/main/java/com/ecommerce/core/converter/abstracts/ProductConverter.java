package com.ecommerce.core.converter.abstracts;

import com.ecommerce.core.model.dto.ProductDTO;
import com.ecommerce.entity.ProductEntity;

public interface ProductConverter {
    ProductEntity createConverter(ProductDTO productDTO);
}
