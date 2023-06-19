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
			int carMo = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter car name" + ConsoleColors.RESET);
			String cName = sc.next();
			
			
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car Type - SUV / Sedan / Minivan" + ConsoleColors.RESET);
			String cType = sc.next();
			
			sc.nextLine();
			System.out.println(ConsoleColors.ORANGE + "Enter Car aviliability date and time in format (YYYY-MM-DD HH:MI:SS)" + ConsoleColors.RESET);
			String availiableTo = sc.nextLine();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car ToTill date and time in format (YYYY-MM-DD HH:MI:SS)" + ConsoleColors.RESET);
			String tillDate = sc.nextLine();
			
			
			System.out.println(ConsoleColors.ORANGE + "Enter Total Cars" + ConsoleColors.RESET);
			int totalCars = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Available Cars" + ConsoleColors.RESET);
			int availCars = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter fare" + ConsoleColors.RESET);
			int fare = sc.nextInt();
			
			Car car = new Car(carMo, cName,  cType, availiableTo,tillDate, totalCars, availCars, fare);
			
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
