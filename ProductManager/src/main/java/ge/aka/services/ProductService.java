package ge.aka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ge.aka.entities.Product;
import ge.aka.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).get();
	}
	
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId);
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
