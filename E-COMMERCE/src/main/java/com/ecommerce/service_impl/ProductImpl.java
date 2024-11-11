package com.ecommerce.service_impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.ProductModel;
import com.ecommerce.model.UpdateProduct;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.service_dao.ProductDao;

@Service
public class ProductImpl implements ProductDao {
	
	@Autowired
	public ProductRepo productRepo;

	

	@Override
	public ProductModel saveProduct(ProductModel prodModel, MultipartFile pimage, MultipartFile pimage1,
			MultipartFile pimage2, MultipartFile pimage3, MultipartFile pimage4) {
		prodModel.setProd_image(pimage.getOriginalFilename());
		prodModel.setProd_image1(pimage1.getOriginalFilename());
		prodModel.setProd_image2(pimage2.getOriginalFilename());
		prodModel.setProd_image3(pimage3.getOriginalFilename());
		prodModel.setProd_image4(pimage4.getOriginalFilename());
		productRepo.save(prodModel);
		
		try {
			File file=new ClassPathResource("static/images").getFile();
			Path path=Paths.get(file.getAbsolutePath()+File.separator+pimage.getOriginalFilename());
			Path path1=Paths.get(file.getAbsolutePath()+File.separator+pimage1.getOriginalFilename());
			Path path2=Paths.get(file.getAbsolutePath()+File.separator+pimage2.getOriginalFilename());
			Path path3=Paths.get(file.getAbsolutePath()+File.separator+pimage3.getOriginalFilename());
			Path path4=Paths.get(file.getAbsolutePath()+File.separator+pimage4.getOriginalFilename());
			System.out.println(path);
			System.out.println(path1);
			System.out.println(path2);
			System.out.println(path3);
			System.out.println(path4);
			Files.copy(pimage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pimage1.getInputStream(), path1, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pimage2.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pimage3.getInputStream(), path3, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(pimage4.getInputStream(), path4, StandardCopyOption.REPLACE_EXISTING);
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return prodModel;
		
	}



	@Override
	public ProductModel updateProduct(int id, UpdateProduct updateProduct,MultipartFile upimage, MultipartFile upimage1,
			MultipartFile upimage2, MultipartFile upimage3, MultipartFile upimage4) {
			
		
			ProductModel productModel=productRepo.getById(id);
		if(productModel!=null) {
			try {
		productModel.setProd_name(updateProduct.getProd_uname());
		productModel.setProd_desc(updateProduct.getProd_udesc());
		productModel.setProd_quantity(updateProduct.getProd_uquantity());
		productModel.setProd_price(updateProduct.getProd_uprice());
		productModel.setProd_actualprice(updateProduct.getProd_uactualprice());
		productModel.setProd_category(updateProduct.getProd_ucategory());
		productModel.setProd_discount(updateProduct.getProd_udiscount());
		productModel.setProd_image(upimage.getOriginalFilename());
		productModel.setProd_image1(upimage1.getOriginalFilename());
		productModel.setProd_image2(upimage2.getOriginalFilename());
		productModel.setProd_image3(upimage3.getOriginalFilename());
		productModel.setProd_image4(upimage4.getOriginalFilename());
		
		productRepo.save(productModel);
		
		
		File file=new ClassPathResource("static/images").getFile();
		Path oldImagePath=Paths.get(file.getAbsolutePath() +File.separator+ productModel.getProd_image());
		System.out.println(oldImagePath);
		Path oldImagePath1=Paths.get(file.getAbsolutePath() +File.separator+ productModel.getProd_image1());
		Path oldImagePath2=Paths.get(file.getAbsolutePath() +File.separator+ productModel.getProd_image2());
		Path oldImagePath3=Paths.get(file.getAbsolutePath() +File.separator+ productModel.getProd_image3());
		Path oldImagePath4=Paths.get(file.getAbsolutePath() +File.separator+ productModel.getProd_image4());
		
		try {
			Files.delete(oldImagePath);
			Files.delete(oldImagePath1);
			Files.delete(oldImagePath2);
			Files.delete(oldImagePath3);
			Files.delete(oldImagePath4);
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
		Path path=Paths.get(file.getAbsolutePath()+File.separator+upimage.getOriginalFilename());
		Path path1=Paths.get(file.getAbsolutePath()+File.separator+upimage1.getOriginalFilename());
		Path path2=Paths.get(file.getAbsolutePath()+File.separator+upimage2.getOriginalFilename());
		Path path3=Paths.get(file.getAbsolutePath()+File.separator+upimage3.getOriginalFilename());
		Path path4=Paths.get(file.getAbsolutePath()+File.separator+upimage4.getOriginalFilename());
		Files.copy(upimage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(upimage1.getInputStream(), path1, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(upimage2.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(upimage3.getInputStream(), path3, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(upimage4.getInputStream(), path4, StandardCopyOption.REPLACE_EXISTING);
		
			} catch (Exception e) {
				}
			// TODO: handle exception
		}
		
		return productModel;
	}
	
	



		
}
