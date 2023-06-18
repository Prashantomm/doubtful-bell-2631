package com.masai.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.bean.Car;
import com.masai.color.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AddCar2usecase {
	public static void AddCar() {

		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car model" + ConsoleColors.RESET);
			int busNo = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter car name" + ConsoleColors.RESET);
			String bName = sc.next();
			
			
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car Type - AC / NonAC" + ConsoleColors.RESET);
			String bType = sc.next();
			
			sc.nextLine();
			
			
			System.out.println(ConsoleColors.ORANGE + "Enter Total Seats" + ConsoleColors.RESET);
			int totalSeats = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Available Seats" + ConsoleColors.RESET);
			int availSeats = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter fare" + ConsoleColors.RESET);
			int fare = sc.nextInt();
			
			Car car = new Car(carMo, cName,  cType,  totalSeats, availSeats, fare);
			
			AdminDao dao = new AdminDaoImpl();
			
			String result = dao.addCar(car);
			
			if (result.equals("Car added Successfully")) {
				System.out.println(ConsoleColors.GREEN_BACKGROUND + result + ConsoleColors.RESET);
			}
			else {
				System.out.println(ConsoleColors.RED_BACKGROUND + result + ConsoleColors.RESET);
			}
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + "Invalid input" + ConsoleColors.RESET);
		}
	}

}
