package pietra.servicoassinaturasvalidas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicoAssinaturasValidasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoAssinaturasValidasApplication.class, args);
	}

}
