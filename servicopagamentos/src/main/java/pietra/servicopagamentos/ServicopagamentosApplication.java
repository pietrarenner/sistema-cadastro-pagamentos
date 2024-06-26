package pietra.servicopagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicopagamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicopagamentosApplication.class, args);
	}

}
