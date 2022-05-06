package com.ecommerce.service.concretes;

import com.ecommerce.core.converter.abstracts.ProductConverter;
import com.ecommerce.core.model.dto.ProductDTO;
import com.ecommerce.dao.abstracts.ProductDao;
import com.ecommerce.entity.ProductEntity;
import com.ecommerce.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductConverter productConverter;
    private final ProductDao productDao;

    @Override
    public void createProduct(ProductDTO productDTO) {
        ProductEntity productEntity=productConverter.createConverter(productDTO);
        productDao.createProduct(productEntity);
    }
}
