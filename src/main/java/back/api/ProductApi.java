package back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import back.domain.entity.Product;
import back.service.ProductService;

@RestController
public class ProductApi {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Product findByIdOrDescriptionContaining(@PathVariable Integer id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/produtos/{description}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Product> findByDescriptionContaining(@PathVariable String description) {
		return service.findByDescriptionContaining(description);
	}
}