package com.masai.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.color.ConsoleColors;

public class Main {
	static void AdminOrCustomer() {
		System.out.println(ConsoleColors.GREEN + "+---------------------------+" + "\n"
						 						   + "| 1. Login As Administrator |" + "\n"
						 						   + "| 2. Login As Customer      |" + "\n"
						 						   + "| 3. Exit                   |" + "\n"
						 						   + "+---------------------------+" + ConsoleColors.RESET);
		System.out.print(ConsoleColors.TEAL + "Please Enter Your Choice : ");
		choice();
	}
	
	static void choice() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + "Input type should be number" + ConsoleColors.RESET);
			AdminOrCustomer();
		}
		
		if (choice == 1) {
			System.out.println(ConsoleColors.ROSY_PINK + "Welcome Admin ! Please Login to your account" + ConsoleColors.RESET);
			AdminLogin();
		}
		else if (choice == 2) {
			System.out.println(ConsoleColors.ROSY_PINK + "Welcome Customer !" + ConsoleColors.RESET);
			customerLoginOrSignup();
		}
		else if (choice == 3) {
			System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
			System.exit(0);
		}
		else {
			System.out.println(ConsoleColors.RED_BACKGROUND + "Please choose a number from below options" + ConsoleColors.RESET);
			AdminOrCustomer();
		}
	}
	
	static void AdminLogin() {
		
		Boolean result = AdminLoginusecase.AdminLogin();

		if (result) adminMethods();
		else {
			AdminLogin();
		}
	}
	
	static void adminMethods() {
		System.out.println(ConsoleColors.GREEN+ "+--------------------------------+" + "\n"
						 + "| Welcome Admin                  |" + "\n"
						 + "| 1. Add Car                     |" + "\n"
						 + "| 2. Confirm Booking of Customer |" + "\n"
						 + "| 3. View All Bookings            |" + "\n"
						 + "| 4. Back                        |" + "\n"
						 + "| 5. Exit                        |" + "\n"
						 + "+--------------------------------+" + ConsoleColors.RESET);
		System.out.print(ConsoleColors.TEAL + "Please Enter Your Choice : ");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println(ConsoleColors.RED_BACKGROUND + "Please choose a number from below options" + ConsoleColors.RESET);
				adminMethods();
			}
			else adminChoice(choice);
		}
		catch (InputMismatchException e) {
			
			System.out.println(ConsoleColors.RED_BACKGROUND + "Input type should be number" + ConsoleColors.RESET);
			adminMethods();
		}
	}
	
	static void adminChoice(int choice) {
		
			switch(choice) {
				case 1 : {
					AddCar2usecase.AddBus();
					adminMethods();
				}
				break;
				case 2 : {
					UpdateStatususecase.updateStatus();
					adminMethods();
				}
				break;
				case 3 : {
					ViewAllBookingsusecase.viewAllTicket();
					adminMethods();
				}
				break;
				case 4 : AdminOrCustomer();
				break;	
				case 5 : {
					System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
					System.exit(0);
				}
			}
	}
	
	static void customerLoginOrSignup() {
		System.out.println(ConsoleColors.GREEN + "+--------------------------------+" + "\n"
				                                + "| 1. Login to your Account       |" + "\n"
				                                + "| 2. Don't have Account? Sign Up |" + "\n"
				                                + "| 3. Back                        |" + "\n"
				                                + "| 4. Exit                        |" + "\n"
				                                + "+--------------------------------+" + ConsoleColors.RESET);
		System.out.print(ConsoleColors.TEAL + "Please Enter Your Choice : ");
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			if (choice == 1) {
				customerLogin();
			}
			else if (choice == 2) {
				customerSignup();
			}
			else if (choice == 3) {
				AdminOrCustomer();
			}
			else if (choice == 4) {
				System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
				System.exit(0);
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND + "Please choose a number from below options" + ConsoleColors.RESET);
				customerLoginOrSignup();
			}
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + "Input type should be number" + ConsoleColors.RESET);
			customerLoginOrSignup();
		}
		
	}
	
	static void customerLogin() {
		Customer customer = CusLoginusecase.CusLogin();
		
		if (customer == null) {
			customerLogin();
		}
		else {
			System.out.println(ConsoleColors.GREEN_BACKGROUND + "Login Successfull" + ConsoleColors.RESET);
			customerMethods(customer);
		}
		
	}
	
	static void customerSignup() {
		boolean flag = CusSignUp2usecase.cusSignUp();
		
		if (flag) {
			System.out.println(ConsoleColors.ROSY_PINK + "Login to your Account" + ConsoleColors.RESET);
			customerLogin();
		}
		else {
			customerSignup();
		}
	}
	
	static void customerMethods(Customer customer) {
		System.out.println(ConsoleColors.PURPLE + "+--------------------------------+" + "\n"
				 		 + "| 1. Book Car             |" + "\n"
				         + "| 2. Cancel Car Booking           |" + "\n"
				         + "| 3. View Status of your Booking |" + "\n"
				         + "| 4. Back                        |" + "\n"
				         + "| 5. Exit                        |" + "\n"
				         + "+--------------------------------+" + ConsoleColors.RESET);
		System.out.print(ConsoleColors.TEAL + "Please Enter Your Choice : ");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println(ConsoleColors.RED_BACKGROUND + "Please choose a number from below options" + ConsoleColors.RESET);
				customerMethods(customer);
			}
			else customerChoice(choice, customer);
		}
		catch (InputMismatchException e) {
			
			System.out.println(ConsoleColors.RED_BACKGROUND + "Input type should be number" + ConsoleColors.RESET);
			customerMethods(customer);
		}
	}
	
	static void customerChoice(int choice, Customer customer) {
		switch(choice) {
		case 1 : {
			BookBookingcNameusecase.BookTicketbName(customer);
			customerMethods(customer);
		}
		break;
		case 2 : {
			CancelBookingcNameusecase.cancelTicket(customer);
			customerMethods(customer);
		}
		break;
		case 3 : {
			ViewBookingusecase.viewTicket(customer);
			customerMethods(customer);
		}
		break;
		case 4 : {
			customerLoginOrSignup();
		}
		case 5 : {
			System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
			System.exit(0);
		}
	}
	}
	

	public static void main(String[] args) {
		
		AdminOrCustomer();
				
	}	


}
