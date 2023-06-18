package com.masai.dao;

import com.masai.bean.Car;

public interface AdminDao {
public final String username = "Admin";
	
	public final String password = "admin";

	public String adminLogin(String username, String password);

	public String addCar(int carMo, String cName,  String cType, 
			int totalSeats, int availSeats, int fare);
	
	public String addCar(Car car);
	
	public String updateStatus(int cusId);

}
