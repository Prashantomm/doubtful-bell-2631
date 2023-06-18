package com.masai.usecases;

import java.util.Scanner;

import com.masai.color.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminLoginusecase {
public static boolean AdminLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE +  "Enter username" + ConsoleColors.RESET);
		String username = sc.next();
		
		System.out.println(ConsoleColors.ORANGE + "Enter password" + ConsoleColors.RESET);
		String password = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		String result =  dao.adminLogin(username, password);
		
		if (result.equals("Login Successfull")){
			System.out.println(ConsoleColors.GREEN_BACKGROUND + result + ConsoleColors.RESET);
			return true;
		}
		else {
			System.out.println(ConsoleColors.RED_BACKGROUND + result + ConsoleColors.RESET);
			return false;
		}

	}

}
