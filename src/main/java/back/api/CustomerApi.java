package back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import back.domain.entity.Customer;
import back.service.CustomerService;

@RestController
public class CustomerApi {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/cliente", method = { RequestMethod.PUT, RequestMethod.POST })
	public @ResponseBody Customer save(@RequestBody Customer customer) throws IllegalAccessException {
		return service.save(customer);
	}

	@RequestMapping(value = "/clientes/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Customer> findByNameContaining(@PathVariable String name) {
		return service.findByNameContaining(name);
	}

}