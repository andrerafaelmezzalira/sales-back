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
import back.service.CustomerRequestService;

@RestController
public class CustomerRequestApi {

	@Autowired
	private CustomerRequestService service;

	@RequestMapping(value = "/pedido", method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody CustomerRequest save(@RequestBody CustomerRequest customerRequest) throws IllegalAccessException {
		return service.save(customerRequest);
	}

	@RequestMapping(value = "/finalizarPedido/{id}")
	public @ResponseBody CustomerRequest finalizeCustomerRequest(@PathVariable Integer id) throws IllegalAccessException {
		return service.finalizeCustomerRequest(id);
	}

	@RequestMapping(value = "/pedidos")
	public @ResponseBody List<CustomerRequest> findAll() {
		return service.findAll();
	}
}