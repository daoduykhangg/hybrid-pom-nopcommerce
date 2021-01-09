package basic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Faker_Data {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en"));
		System.out.println(faker.company().name());
	}

}
