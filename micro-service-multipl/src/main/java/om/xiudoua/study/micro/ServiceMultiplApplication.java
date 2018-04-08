package om.xiudoua.study.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceMultiplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMultiplApplication.class, args);
	}
	
}