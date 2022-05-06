package com.ecommerce.core.converter.concretes;

import com.ecommerce.core.converter.abstracts.ProductConverter;
import com.ecommerce.core.model.dto.ProductDTO;
import com.ecommerce.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ProductConverterImpl implements ProductConverter {
    @Override
    public ProductEntity createConverter(ProductDTO productDto) {
        ProductEntity product=new ProductEntity();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        product.setCategory(productDto.getCategory());
        product.setCreatedAt(new Date());
        product.setCreatedBy(productDto.getName());

        UUID uuid=UUID.randomUUID();
        product.setBarcode(uuid);
        return product;
    }
}
