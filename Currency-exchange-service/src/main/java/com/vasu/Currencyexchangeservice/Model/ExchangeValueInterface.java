package com.vasu.Currencyexchangeservice.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueInterface extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
