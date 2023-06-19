package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.color.ConsoleColors;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CarException;

public class CancelBookingcNameusecase {
	public  static void cancelBooking(Customer customer) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE + "Enter Car Name" + ConsoleColors.RESET);
		String cName = sc.nextLine();
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			
			int cusId = customer.getCusId();
			String message = dao.cancelBooking(cName, cusId);
			
			if (message.equals("Booking cancelled Successfully")) {
				System.out.println(ConsoleColors.GREEN_BACKGROUND + message + ConsoleColors.RESET);
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND + message + ConsoleColors.RESET);
			}
			
		} catch (CarException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
		}
	
	}


}
