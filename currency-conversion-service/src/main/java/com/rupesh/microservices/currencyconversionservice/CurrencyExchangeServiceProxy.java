package com.rupesh.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
// Redirect every request to the Zuul API Gateway
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//Need to append service name before uri because we are using API Gateway
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
