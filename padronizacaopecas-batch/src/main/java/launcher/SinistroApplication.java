package launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import config.PadronizacaoPecasJob;

@SpringBootApplication
public class SinistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinistroApplication.class, args);
		
		System.exit(SpringApplication.exit(SpringApplication.run(PadronizacaoPecasJob.class, args)));
		
	}

}
