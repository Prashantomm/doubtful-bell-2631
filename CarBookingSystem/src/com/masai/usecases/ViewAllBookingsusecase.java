package com.masai.usecases;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class ViewAllBookingsusecase {
public static void viewAllBooking() {
		
		AdminDao dao = new AdminDaoImpl();
		((AdminDaoImpl) dao).viewAllBookings();
	}


}
