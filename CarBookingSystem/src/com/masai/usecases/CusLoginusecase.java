package com.masai.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.color.ConsoleColors;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;

public class CusLoginusecase {
public static Customer CusLogin() {
		
		Customer customer = null;
		
		try {
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println(ConsoleColors.ORANGE + "Enter Username" + ConsoleColors.RESET);
			String username = sc.next();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Password" + ConsoleColors.RESET);
			String password = sc.next();
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				customer = dao.cusLogin(username, password);
				
				System.out.println(ConsoleColors.ROSY_PINK + "Welcome " + customer.getFirstName() + " " + customer.getLastName() + ConsoleColors.RESET);
			} catch (CustomerException e) {
				
				System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
			}
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
		}
		
		return customer;

	}

}
