package com.sousa.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchPadronizaCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchPadronizaCodigoApplication.class, args);
	}

}
