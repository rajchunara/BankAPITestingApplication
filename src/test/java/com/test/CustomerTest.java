package com.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.model.Customer;
import com.service.CustomerAPIData;
import com.service.CustomerTestData;

public class CustomerTest {
	
	static CustomerAPIData customerAPIData;
	static CustomerTestData customerTestData;
	
	static Customer actualAPICustomer;
	static Customer expectedTestDataCustomer;
	
	
	/* Setup Test data */
	@BeforeClass
	public static void getCustomerData() {
		customerAPIData = new CustomerAPIData();
		customerTestData = new CustomerTestData();		
		
		expectedTestDataCustomer= customerTestData.getCustomerTestData();	
		actualAPICustomer = customerAPIData.getCustomerAPIDataUsingAccountNumber(expectedTestDataCustomer.getAccountNumber());
		
	}
	
	@Test
	public void checkAccountNumberOfCustomer() {
		Assert.assertEquals(expectedTestDataCustomer.getAccountNumber(), actualAPICustomer.getAccountNumber());
	}
	
	@Test
	public void checkBalance() {
		Assert.assertEquals(expectedTestDataCustomer.getBalance(), actualAPICustomer.getBalance(), 0.0f);
	
	}
	
	@Test
	public void checkEmailAddress() {
		Assert.assertEquals(expectedTestDataCustomer.getEmail(), actualAPICustomer.getEmail());
				}
	
	@Test 
	public void checkPhoneNumber() {
		Assert.assertEquals(expectedTestDataCustomer.getPhoneNumber(), actualAPICustomer.getPhoneNumber());
	}
	

}
