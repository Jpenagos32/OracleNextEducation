package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ES MUY IMPORTANTE VERIFICAR LA VERSION DE LOMBOK, DE LO CONTRARIO NO FUNCIONA
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
