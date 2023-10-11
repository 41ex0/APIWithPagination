package Principal.TPAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
		System.out.println("Estoy funcionando ;)");
	}
}