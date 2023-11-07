package uniandes.edu.co.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootApplication
@ComponentScan("uniandes.edu.co.proyecto") 
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
