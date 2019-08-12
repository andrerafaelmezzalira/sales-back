package back.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import back.domain.entity.Product;

public interface ProductRepository extends Repository<Product, Integer> {

	Product findById(Integer id);

	List<Product> findByDescriptionContaining(String description);
}
