package org.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.system.repository")
@EntityScan(basePackages = "org.system.entity")
public class LocadoraCarrosApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocadoraCarrosApplication.class, args);
	}

}
