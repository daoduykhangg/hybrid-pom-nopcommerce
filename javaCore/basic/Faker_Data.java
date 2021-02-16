package basic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Faker_Data {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en"));
		System.out.println(faker.company().name());
		
		System.out.println(faker.address().country());
		System.out.println(faker.address().state());
		System.out.println(faker.address().cityName());
		System.out.println(faker.address().streetAddress());
		System.out.println(faker.address().fullAddress());
		System.out.println(faker.address().zipCode());
		System.out.println(faker.phoneNumber().cellPhone());
		System.out.println(faker.business().creditCardNumber());
	}

}
