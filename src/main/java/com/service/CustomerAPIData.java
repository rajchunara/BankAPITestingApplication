package com.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import com.google.gson.Gson;
import com.model.Customer;
import com.util.ConfigReader;

public class CustomerAPIData {
	private ConfigReader configReader;
	Properties prop;
	String configApiURL;


	public CustomerAPIData() {
		super();
		configReader = new ConfigReader();
		prop=configReader.init_props();
		configApiURL = prop.getProperty("apiURL");
	}


	public Customer getCustomerAPIDataUsingAccountNumber(Long accNumber ) {		

		Customer customer = null;
		Gson gson = new Gson();		

		String apiURL = configApiURL+ accNumber.toString();

		try (InputStream is = new URL(apiURL).openStream();
				Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

			customer = gson.fromJson(reader, Customer.class);


		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}


		return customer;


	}

}
