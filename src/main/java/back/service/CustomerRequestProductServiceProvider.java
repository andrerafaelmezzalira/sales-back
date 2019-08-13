package back.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.CustomerRequest;
import back.domain.entity.CustomerRequestProduct;
import back.domain.entity.CustomerRequestProductId;
import back.domain.entity.Product;
import back.domain.repository.CustomerRequestProductRepository;

@Service
public class CustomerRequestProductServiceProvider implements CustomerRequestProductService {

	@Autowired
	private CustomerRequestProductRepository repository;

	@Autowired
	private CustomerRequestService customerRequestService;

	@Override
	public CustomerRequestProduct save(CustomerRequestProduct customerRequestProduct) throws IllegalAccessException {

		validations(customerRequestProduct);

		double ammountSubstract = 0.0;
		CustomerRequestProductId customerRequestProductId = new CustomerRequestProductId();
		customerRequestProductId.setCustomerRequest(customerRequestProduct.getCustomerRequest());
		customerRequestProductId.setProduct(customerRequestProduct.getProduct());
		CustomerRequestProduct customerRequestProductBd = repository.findById(customerRequestProductId);

		if (customerRequestProductBd != null) {
			// caso esteja alterando um item de pedido, devemos subtrair do valor total do
			// pedido o valor para depois acertamos de acordo com a nova quantidade
			ammountSubstract = getAmmount(customerRequestProductBd);
		}

		repository.save(customerRequestProduct);

		// update no valor total do pedido
		CustomerRequest customerRequest = customerRequestService
				.findById(customerRequestProduct.getCustomerRequest().getId());

		double ammount = getAmmount(customerRequestProduct);

		subtractAmmount(customerRequest, ammountSubstract);

		customerRequest.setAmount(customerRequest.getAmount().add(new BigDecimal(ammount)));

		updateAmmountCustomerRequest(customerRequest);

		return customerRequestProduct;
	}

	@Override
	public void delete(Integer idCustomerRequest, Integer idProduct) throws IllegalAccessException {

		CustomerRequestProductId customerRequestProductId = new CustomerRequestProductId();
		Product product = new Product();
		product.setId(idProduct);
		customerRequestProductId.setProduct(product);
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setId(idCustomerRequest);
		customerRequestProductId.setCustomerRequest(customerRequest);
		CustomerRequestProduct customerRequestProduct = repository.findById(customerRequestProductId);
		
		if (customerRequestProduct == null) {
			throw new IllegalAccessException("Item não localizado");
		}

		// update no valor total do pedido
		CustomerRequest customerRequestBd = customerRequestService
				.findById(customerRequestProduct.getCustomerRequest().getId());

		double ammount = getAmmount(customerRequestProduct);

		subtractAmmount(customerRequestBd, ammount);

		updateAmmountCustomerRequest(customerRequestBd);

		repository.delete(customerRequestProduct);
	}

	private void subtractAmmount(CustomerRequest customerRequest, double ammount) {
		// subtrai do valor total o valor a ser retirado
		customerRequest.setAmount(customerRequest.getAmount().subtract(new BigDecimal(ammount)));
	}

	private void validations(CustomerRequestProduct customerRequestProduct) throws IllegalAccessException {

		if (customerRequestProduct.getProduct() == null || customerRequestProduct.getCustomerRequest() == null
				|| customerRequestProduct.getAmount() == null) {
			throw new IllegalAccessException("Campos obrigatórios não preenchidos");
		}
	}

	private double getAmmount(CustomerRequestProduct customerRequestProduct) {
		// quantidade * valor do produto
		return customerRequestProduct.getAmount() * customerRequestProduct.getProduct().getValue().doubleValue();
	}

	private void updateAmmountCustomerRequest(CustomerRequest customerRequest) throws IllegalAccessException {
		customerRequestService.save(customerRequest);
	}

	@Override
	public List<CustomerRequestProduct> findByCustomerRequest(CustomerRequest customerRequest) {
		return repository.findByCustomerRequest(customerRequest);
	}
}