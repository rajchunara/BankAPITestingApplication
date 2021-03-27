package com.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.model.Customer;
import com.util.ConfigReader;

public class CustomerTestData {
	private Customer customer=null;
	private InputStream ioStream ;
	private Reader reader;
	private ConfigReader configReader;
	Properties prop;
	String testDataFilePath;
	
	public CustomerTestData() {
		configReader = new ConfigReader();
		prop=configReader.init_props();
		testDataFilePath = prop.getProperty("testDataFilePath");
	}

	public Customer getCustomerTestData() {
        Path path = Paths.get(testDataFilePath);
        
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            Customer customer = gson.fromJson(reader, 
                    new TypeToken<Customer>(){}.getType());
            
            return customer;
            
        }        
        catch(Exception e) {
        	System.out.println(e.getStackTrace());
        }
        
        
        return customer;
	}

}
