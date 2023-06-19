package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Customer;
import com.masai.color.ConsoleColors;
import com.masai.exceptions.CarException;
import com.masai.exceptions.CustomerException;
import com.masai.utility.DButil;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public String cusSignUp(String username, String password, String firstName, String lastName, String address,
			String mobile) {
		
		String message = "Sign up Failed";
		
		try(Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("insert into customer(username, password, firstName, lastName, address, mobile) values (?,?,?,?,?,?)");
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,  firstName);
			ps.setString(4,  lastName);
			ps.setString(5,  address);
			ps.setString(6,  mobile);
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = "Sign up Successfull";
			
		}
		catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String cusSignUp(Customer customer) {
		
		String message = "Sign up Failed";
		
		try(Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("insert into customer(username, password, firstName, lastName, address, mobile) values (?,?,?,?,?,?)");
			
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirstName());
			ps.setString(4, customer.getLastName());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getMobile());
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = "Sign up Successfull";
			
		}
		catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
		
	}

	@Override
	public Customer cusLogin(String username, String password) throws CustomerException {
		
		Customer customer = null;
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()) {
				int cusId = rs.getInt("cusId");
				String usernamee =  rs.getString("username");
				String passwordd = rs.getString("password");
				String firstName = rs.getString("firstName");		
				String lastName = rs.getString("lastName");			
				String address = rs.getString("address");			
				String mobile = rs.getString("mobile");
				
				customer = new Customer(cusId,usernamee, passwordd, firstName, lastName, address, mobile);
				
			}
			else {
				throw new CustomerException("Invalid username or password");
				
			}
			
		}
		catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return customer;
	}

	@Override
	public String bookBooking(String cName, int cusId, int no) throws CarException {
	
		String message = "Booking fail";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from car where cName = ?");
			ps.setString(1, cName);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int carMo = rs.getInt("carMo");
				int totalCars = rs.getInt("totalCars");
				int availCars = rs.getInt("availCars");
				Date departure = rs.getDate("availiableTo");
				int fare = rs.getInt("fare");
				
				PreparedStatement ps1 = conn.prepareStatement("select datediff(?,current_date()) as date");
				ps1.setDate(1, departure);
				
				ResultSet rs1 = ps1.executeQuery();
				int days = 0;
				if (rs1.next()) {
					days = rs1.getInt("date");
				}
				
				if (days <= 0) {
				throw new CarException("Booking is not available for this date");
				}
				else if (availCars >= no) {
					int carFrom = totalCars - availCars + 1;
					int carTo = carFrom + no -1;
					fare = fare * no;
					
					PreparedStatement ps2 = conn.prepareStatement("insert into booking(cusId, carMo,carFrom,carTo) values (?, ?,?,?)");
					ps2.setInt(1, cusId);
					ps2.setInt(2, carMo);
					ps2.setInt(3, carFrom);
					ps2.setInt(4, carTo);
					
					int x = ps2.executeUpdate();

					if (x > 0) {
						
						PreparedStatement ps3 = conn.prepareStatement("update car set availcars = ? where carMo = ?");
						availCars = availCars - no;
						ps3.setInt(1, availCars);
						ps3.setInt(2, carMo);
						int y = ps3.executeUpdate();
						
						if (y <= 0) throw new CarException("Available Car is not updated");
						
						
						System.out.println(ConsoleColors.ROSY_PINK + "--------------------------------------------" + "\n"
																   + "Customer Id is : " + cusId + "\n"
																   + "car Model is : " + carMo + "\n"
																   + "Car No is from : " + carFrom + " to " + carTo + "\n"
																   + "Bus fare is : " + fare + "\n"
																   + "Booking yet to be confirm by Adminstrator" + "\n" 
																   + "---------------------------------------------" + ConsoleColors.RESET);
						
						 message = "Booked Successfully";
					}
				
				}
	
			}
			else {
				throw new CarException("Car with " + cName + " is not available");
			}
			
		}
		catch (SQLException e) {
			throw new CarException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String cancelBooking(String cName, int cusId) throws CarException {
		String message = "Booking cancellation failed";
		
		try (Connection conn = DButil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from car where cName = ?");
				ps.setString(1, cName);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					
					int carMo = rs.getInt("carMo");
					int availCars = rs.getInt("availCars");
					
					PreparedStatement ps1 = conn.prepareStatement("select * from booking where carMo = ? and cusId = ?");
					ps1.setInt(1, carMo);
					ps1.setInt(2, cusId);
					
					ResultSet rs1 = ps1.executeQuery();
					boolean flag = false;
					int count = 0;
					
					while (rs1.next()) {
						flag = true;
						int carFrom = rs1.getInt("carFrom");
						int carTo = rs1.getInt("carTo");
						count += carTo - carFrom + 1;
					}
					
				    if (flag) {
						
						PreparedStatement ps2 = conn.prepareStatement("delete from booking where carMo = ? and cusId = ?");
						ps2.setInt(1, carMo);
						ps2.setInt(2, cusId);
						
						int x = ps2.executeUpdate();
						if (x > 0) {
							
							PreparedStatement ps3 = conn.prepareStatement("update car set availCars = ? where carMo = ?");
							availCars = availCars + count;
							ps3.setInt(1, availCars);
							ps3.setInt(2, carMo);
							int y = ps3.executeUpdate();
							
							if (y <= 0) throw new CarException("Available Car is not updated");
							
							 message = "Booking cancelled Successfully";
						}
					
					}
				    else message = "No booking found";
		
				}
				else {
					throw new CarException("Car with " + cName + " is not available");
				}
				
			}
			catch (SQLException e) {
				throw new CarException(e.getMessage());
			}
		
		return message;
	
	}

	@Override
	public void viewBooking(int cusId) {
		boolean flag = false;
		
		try(Connection conn = DButil.provideConnection()){
			PreparedStatement ps1 = conn.prepareStatement("select * from booking where cusId = ?");
			ps1.setInt(1, cusId);
			
			ResultSet rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				flag = true;
				System.out.println(ConsoleColors.ROSY_PINK + "---------------------------------------------" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.ROSY_PINK + "Car Id : " + rs1.getInt("cId") + ConsoleColors.RESET);
				System.out.println(ConsoleColors.ROSY_PINK + "Car Model : " + rs1.getInt("carMo") + ConsoleColors.RESET);
			System.out.println(ConsoleColors.ROSY_PINK + "Total Booking : " + (rs1.getByte("carTo") - rs1.getInt("carFrom") + 1) + ConsoleColors.RESET);
				if (rs1.getBoolean("status")) System.out.println(ConsoleColors.ROSY_PINK + "Status : Booked"  + ConsoleColors.RESET);
				else System.out.println(ConsoleColors.ROSY_PINK + "Status : Pending" + ConsoleColors.RESET);
				
				System.out.println(ConsoleColors.ROSY_PINK + "----------------------------------------------" + ConsoleColors.RESET);
			}
			
			if (flag == false) System.out.println(ConsoleColors.RED_BACKGROUND + "No Booking found" + ConsoleColors.RESET);
		}
		catch (SQLException s){
			System.out.println(ConsoleColors.RED_BACKGROUND + s.getMessage() + ConsoleColors.RESET);
		}
		
	}

	


	

	
}
