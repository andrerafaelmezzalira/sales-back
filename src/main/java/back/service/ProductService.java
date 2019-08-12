package back.service;

import java.util.List;

import back.domain.entity.Product;

public interface ProductService {

	Product findById(Integer id);

	List<Product> findByDescriptionContaining(String description);
}