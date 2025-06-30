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
	public int index() {
//		int num = 2222;
//		boolean kir = true;
//		byte byte1 = 10;
//		short short1 = 100;
//		byte1 = (byte) short1;
//        String str3 = "xxxx";

//		if (byte1 == short1 ) {
//			System.out.println("log");
//		}

//		for (int i = 1; i <= 2; i ++) {
//			System.out.println(i);
//		}

//		String[] cars = {"bmw", "benz"};
//		for (String car: cars) {
//			System.out.println(car);
//		}

//		final String[] args = {"x", "y"};
//		logData(args);

//		Car benz = new Car(800);
//		benz.price = 200;
//		cons(benz.getPrice());
//		this.cons(benz.price);

		Benz benz2 = new Benz(150);
		cons(benz2.getPrice());

		return benz2.getPrice();
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

//	static void logData (String[] args) {
//		System.out.println( String.join(", ", args));
//	}

	final void cons (int str) {
		System.out.println(str);
	}
}
