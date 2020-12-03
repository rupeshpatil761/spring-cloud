package com.rupesh.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment enviornment;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to")  String to) {
		logger.info("inside CurrencyExchangeController");
		return new ExchangeValue(101l,from,to,BigDecimal.valueOf(65),enviornment.getProperty("local.server.port"));
	}
}
