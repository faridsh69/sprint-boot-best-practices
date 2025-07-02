package com.farid.Divar.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Index {
  	public String index() {
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
//		benz2.start(); run threat
		console(benz2.getPrice());
		TypeData<roles> xxx = new  TypeData<>(roles.USER);

		System.out.println(xxx.value);
		LocalDate date = LocalDate.now(); // Create a date object
		System.out.println(date); // Display the current date

		String[] numbersx = {"1111", "22222"};
		this.printArray(numbersx);

		try {
			int xx = 1 / 1;
//			throw new ArithmeticException("Access denied - You must be at least 18 years old.");

		} catch (Exception e) {
			System.out.println(e);
		}

		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(5);
		Consumer<Integer> method = (n) -> { System.out.println(n); };
		numbers.forEach( method );

		FunctionInterface sum = (a, b) -> a + b;
		FunctionInterface mult = (a, b) -> a * b;
		console(sum.calc(1, 7));
		console(mult.calc(1, 7));
		console(benz2.getPrice());

		return "QWE QWE";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

//	static void logData (String[] args) {
//		System.out.println( String.join(", ", args));
//	}

	public static <T> void printArray(T[] arr) {
		for (T item : arr) {
			System.out.println(item);
		}
	}

	public static <T> void console(T any) {

		System.out.println(any);

	}
}

enum roles {
	ADMIN,
	USER
}

interface FunctionInterface {
	int calc(int a, int b);
}


