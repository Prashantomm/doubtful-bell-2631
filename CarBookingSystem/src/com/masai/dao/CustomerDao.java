package com.masai.dao;

import com.masai.bean.Customer;
import com.masai.exceptions.CarException;
import com.masai.exceptions.CustomerException;

public interface CustomerDao {
public String cusSignUp (String username, String password, String firstName, String lastName, String address, String mobile) ;
	
	public String cusSignUp (Customer customer);
	
	public Customer cusLogin (String username, String password) throws CustomerException;
	
	public String bookBooking (String cName, int cusId, int no) throws CarException;
	
	public String cancelBooking(String cName, int cusId) throws CarException;
	
	public void viewBooking(int cusId);

	String cancelBookig(String cName, int cusId) throws CarException;

}
