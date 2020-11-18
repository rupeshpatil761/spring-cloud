package com.rupesh.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();

		// CurrencyConversionBean(response.getId(),from,to,response.getQuantity(),BigDecimal.valueOf(quantity),response.getTotalCalculatedAmount(),enviornment.getProperty("local.server.port"));
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getServerPort());
	}
	
	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retriveExchangeValueFeign(@PathVariable("from") String from, @PathVariable("to")  String to,
			@PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retriveExchangeValue(from, to);

		// CurrencyConversionBean(response.getId(),from,to,response.getQuantity(),BigDecimal.valueOf(quantity),response.getTotalCalculatedAmount(),enviornment.getProperty("local.server.port"));
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getServerPort());
	}

}
