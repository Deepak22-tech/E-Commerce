package com.ecommerce.service_dao;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.ProductModel;
import com.ecommerce.model.UpdateProduct;

public interface ProductDao {

	public ProductModel saveProduct(ProductModel prodModel, MultipartFile pimage,MultipartFile pimage1,MultipartFile pimage2,MultipartFile pimage3,MultipartFile pimage4);

	public ProductModel updateProduct(int id, UpdateProduct updateProduct, MultipartFile upimage, MultipartFile upimage1,
			MultipartFile upimage2, MultipartFile upimage3, MultipartFile upimage4);
}
