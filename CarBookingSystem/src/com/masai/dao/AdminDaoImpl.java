package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Car;
import com.masai.color.ConsoleColors;
import com.masai.utility.DButil;

public class AdminDaoImpl implements AdminDao{
	@Override
	public String adminLogin(String username, String password) {
		
		String message = "Invalid username or password";
		
		if (username.equals(AdminDao.username) && password.equals(AdminDao.password)) {
			 message = "Login Successfull";
		}
		
		return message;
	}

	@Override
	public String addCar(int carMo, String cName,  String cType,String tillDate,String availiableTo,
			int totalCars, int availCars, int fare) {
		
		String message = "car not Added";
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into car values (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, carMo);
			ps.setString(2, cName);
			
			
			ps.setString(3, cType);
			ps.setString(4, availiableTo);
			ps.setString(5, tillDate);
			
			ps.setInt(6,totalCars);
			ps.setInt(7, availCars);
			ps.setInt(8, fare);
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = "Car added Successfully";
			
		}
		catch (SQLException e) {
			message  = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String addCar(Car car) {
		String message = "Car not Added";
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into car values (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, car.getCarMo());
			ps.setString(2, car.getcName());
			ps.setString(3, car.getcType());
			ps.setString(4, car.getAvailiableTo());
			ps.setString(5, car.getTillDate());
			ps.setInt(6,car.getTotalCars());
			ps.setInt(7, car.getAvailCars());
			ps.setInt(8, car.getFare());
			
			int x = ps.executeUpdate();
			
			if (x > 0)  message = "Car added Successfully";
			
		}
		catch (SQLException e) {
			message  = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateStatus(int cusId) {
		String message = "Status not update for customer Id : " + cusId;
		
		try(Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update booking set status = true where cusId = ?");
			ps.setInt(1, cusId);
			
			int x = ps.executeUpdate();
			if (x > 0) message = "Status successfully updated for customer Id : " + cusId;
			
		}
		catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	public void viewAllBookings() {
		boolean flag = false;
		
		try(Connection conn = DButil.provideConnection()){
			PreparedStatement ps1 = conn.prepareStatement("select * from booking");
			
			ResultSet rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				flag = true;
				
				System.out.println(ConsoleColors.ROSY_PINK + "----------------------------------------------------" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.ROSY_PINK + "Bus Id : " + rs1.getInt("cId") + ConsoleColors.RESET);
				System.out.println(ConsoleColors.ROSY_PINK + "Bus No : " + rs1.getInt("carMo") + ConsoleColors.RESET);
				System.out.println(ConsoleColors.ROSY_PINK + "Total Car bookings : " + (rs1.getInt("carTo") - rs1.getInt("carFrom") + 1) + ConsoleColors.RESET);
				if (rs1.getInt("status") == 1) System.out.println(ConsoleColors.ROSY_PINK + "Status : Booked" + ConsoleColors.RESET);
				else System.out.println(ConsoleColors.ROSY_PINK + "Status : Pending" + ConsoleColors.RESET);
				
				System.out.println(ConsoleColors.ROSY_PINK + "----------------------------------------------------" + ConsoleColors.RESET);
			}
			
			if (flag == false) System.out.println(ConsoleColors.RED_BACKGROUND + "No booking found" + ConsoleColors.RESET);
		}
		catch (SQLException s){
			System.out.println(ConsoleColors.RED_BACKGROUND + s.getMessage() + ConsoleColors.RESET);
		}
		
		
		
	}

	

	

}
