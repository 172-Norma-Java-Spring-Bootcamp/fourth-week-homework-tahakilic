package com.ecommerce.core.model.dto;

import com.ecommerce.entity.BrandEntity;
import com.ecommerce.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String image;
    @NotNull
    private BrandEntity brand;
    @NotNull
    private CategoryEntity category;

}
