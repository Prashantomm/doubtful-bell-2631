package com.masai.usecases;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class ViewBookingusecase {
public static void viewBooking(Customer customer) {
		
		CustomerDao dao = new CustomerDaoImpl();
		
		dao.viewBooking(customer.getCusId());
	}

}
