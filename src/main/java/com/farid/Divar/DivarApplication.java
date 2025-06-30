package com.farid.Divar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DivarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivarApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		int num = 2222;
		boolean kir = true;
		byte byte1 = 10;
		short short1 = 100;
		byte1 = (byte) short1;
        String str3 = "xxxx";

		if (byte1 == short1 ) {
			System.out.println("log");
		}
		for (int i = 1; i <= 5; i ++) {
			System.out.println(i);
		}

		String[] cars = {"bmw", "benz"};
		for (String car: cars) {
			System.out.println(car);
		}

		return kir ? byte1 + str3 : Integer.toString(num);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
