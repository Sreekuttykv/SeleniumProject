package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	public String createARandomFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String createRandomLastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public String createRandomAddress() {
		Faker faker = new Faker();
		return faker.address().fullAddress();
	}

	public String createRandomPhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().toString();
	}

	public String createRandomjob() {
		Faker faker = new Faker();
		return faker.job().field();
	}

	public String generateEmail() {
		Faker faker = new Faker();
		return faker.internet().emailAddress(); // Generates an email address
	}

	public int generateRandomInt(int min, int max) {
		Faker faker = new Faker();
		return faker.number().numberBetween(min, max);
	}

	public String generateRandomDigits(int count) {
		Faker faker = new Faker();
		return faker.number().digits(count);
	}

	public int generateRandomNumber() {
		Faker faker = new Faker();
		return faker.number().randomDigit();
	}
}
