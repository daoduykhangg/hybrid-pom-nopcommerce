package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static FakerConfig getFakerData() {
		return new FakerConfig();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password(6, 8);
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
}
