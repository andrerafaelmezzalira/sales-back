package back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import back.domain.entity.CustomerRequest;
import back.domain.entity.CustomerRequestProduct;
import back.service.CustomerRequestProductService;

@RestController
public class CustomerRequestProductApi {

	@Autowired
	private CustomerRequestProductService service;

	@RequestMapping(value = "/item", method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody CustomerRequestProduct insert(@RequestBody CustomerRequestProduct customerRequestProduct)
			throws IllegalAccessException {
		return service.save(customerRequestProduct);
	}

	@RequestMapping(value = "/item/{idCustomerRequest}/{idProduct}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer idCustomerRequest, @PathVariable Integer idProduct) throws IllegalAccessException {
		service.delete(idCustomerRequest, idProduct);
	}

	@RequestMapping(value = "/itens/pedido/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<CustomerRequestProduct> findByCustomerRequest(@PathVariable Integer id)
			throws IllegalAccessException {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setId(id);
		return service.findByCustomerRequest(customerRequest);
	}

}