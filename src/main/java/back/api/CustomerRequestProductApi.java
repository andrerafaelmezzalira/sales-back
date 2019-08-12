package back.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import back.domain.entity.CustomerRequestProduct;
import back.service.CustomerRequestProductService;

@RestController
public class CustomerRequestProductApi {

	@Autowired
	private CustomerRequestProductService service;

	@RequestMapping(value = "/item", method = { RequestMethod.POST, RequestMethod.PUT })
	public void insert(@RequestBody CustomerRequestProduct customerRequestProduct) throws IllegalAccessException {
		service.save(customerRequestProduct);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws IllegalAccessException {
		service.delete(id);
	}
}