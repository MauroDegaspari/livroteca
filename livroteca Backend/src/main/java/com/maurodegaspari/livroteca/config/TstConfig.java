package com.maurodegaspari.livroteca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maurodegaspari.livroteca.services.DBtesteServices;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("tst")
public class TstConfig {

	@Autowired
	private DBtesteServices tst;

	@PostConstruct // indica que um método deve ser executado automaticamente após o Spring instanciar o bean e injetar as dependências.
	public void chamaBancoTst() {

		this.tst.insertBancoTest();
	}
}
