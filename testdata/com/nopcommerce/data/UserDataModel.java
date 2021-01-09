package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDataModel {
	public static UserDataModel getValue(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(filename), UserDataModel.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	static class Register {
		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("company")
		private String company;
	}

	@JsonProperty("register")
	Register register;
	
	public String getFirstname() {
		return register.firstname;
	}
	public String getLastname() {
		return register.lastname;
	}
	public String getCompany() {
		return register.company;
	}
	
	
	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
