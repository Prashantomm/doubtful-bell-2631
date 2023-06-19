package com.masai.dao;

import com.masai.bean.Car;

public interface AdminDao {
public final String username = "admin";
	
	public final String password = "admin";

	public String adminLogin(String username, String password);

	public String addCar(int carMo, String cName,  String cType, String tillDate,String availiableTo,
			int totalCars, int availCars, int fare);
	
	public String addCar(Car car);
	
	public String updateStatus(int cusId);

}
