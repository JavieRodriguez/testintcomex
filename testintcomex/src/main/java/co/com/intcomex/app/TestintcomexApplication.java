package co.com.intcomex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("co.com.intcomex.app.models.dao")
@EntityScan("co.com.intcomex.app.models.entity")
public class TestintcomexApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestintcomexApplication.class, args);
	}

}
