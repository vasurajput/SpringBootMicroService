package com.vasu.Limit_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasu.Limit_Service.Model.LimitConfiguration;
import com.vasu.Limit_Service.configuration.Configuration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/")
	public LimitConfiguration retrieveLimitFromConfiguration() {
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
}
