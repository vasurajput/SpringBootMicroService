package com.vasu.Currencyexchangeservice.cotroller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vasu.Currencyexchangeservice.Model.ExchangeValue;
import com.vasu.Currencyexchangeservice.Model.ExchangeValueInterface;

@RestController
public class CurrencyExchangeService {

	@Autowired
	private Environment environment; // spring boot provide this, this is used to get runnign port details

	@Autowired
	private ExchangeValueInterface repositry;

	/*
	 * NOTE: For Runnign Multiple instance of a apllication go to your project click
	 * on Run As -> Run Configuration go to java aplication change name of
	 * application and give argument in eclipse -Dserver.port=8081 and click on
	 * apply then run
	 */

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		try {
//			ExchangeValue v = new ExchangeValue(1L, from, to, BigDecimal.valueOf(65));
			ExchangeValue v = repositry.findByFromAndTo(from, to);
			// v.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
