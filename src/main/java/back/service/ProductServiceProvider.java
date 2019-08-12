package back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.Product;
import back.domain.repository.ProductRepository;

@Service
public class ProductServiceProvider implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Product> findByDescriptionContaining(String description) {
		return repository.findByDescriptionContaining(description);
	}
}