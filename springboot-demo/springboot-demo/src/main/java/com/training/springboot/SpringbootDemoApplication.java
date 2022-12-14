package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
@RestController
class MyController {
	@GetMapping(value = "/name")
	public String getName() {
		return "Ashwath";
	}

	@GetMapping(value = "/name/{hobby}")
	public String getHobby(@PathVariable("hobby") String hobby) {
		return "My hobby is " + hobby;
	}
}