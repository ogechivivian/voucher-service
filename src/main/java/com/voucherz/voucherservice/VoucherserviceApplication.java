package com.voucherz.voucherservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class VoucherserviceApplication implements CommandLineRunner {
	public static final String EXCHANGE_NAME = "regExchange";
	public static final String QUEUE_NAME = "regQueue";
	public static final String ROUTING_KEY = "registration.key";

	public static void main(String[] args) {
		SpringApplication.run(VoucherserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

