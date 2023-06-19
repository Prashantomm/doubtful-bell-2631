package com.masai.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.color.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AddCar1usecase {
public static void AddCar() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car Model" + ConsoleColors.RESET);
			int carMo = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car name" + ConsoleColors.RESET);
			String cName = sc.next();
			
		
			System.out.println(ConsoleColors.ORANGE + "Enter Car Type - SUV / Sedan / Minivan" + ConsoleColors.RESET);
			String cType = sc.next();
			
			sc.nextLine();
			System.out.println(ConsoleColors.ORANGE + "Enter Car aviliability date and time in format (YYYY-MM-DD HH:MI:SS)" + ConsoleColors.RESET);
			String availiableTo = sc.nextLine();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Car ToTill date and time in format (YYYY-MM-DD HH:MI:SS)" + ConsoleColors.RESET);
			String tillDate = sc.nextLine();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Total Car" + ConsoleColors.RESET);
			int totalCars = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter Available Car" + ConsoleColors.RESET);
			int availCars = sc.nextInt();
			
			System.out.println(ConsoleColors.ORANGE + "Enter fare" + ConsoleColors.RESET);
			int fare = sc.nextInt();
			
			AdminDao dao = new AdminDaoImpl();
			
			String result = dao.addCar(carMo, cName, cType, availiableTo,tillDate, totalCars, availCars, fare);
			
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
