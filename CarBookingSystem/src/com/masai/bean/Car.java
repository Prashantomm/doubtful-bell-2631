package com.masai.bean;

public class Car {
	private int carMo;
	 
	 private String cName;
	  
	 private String cType;
	  
	 private int totalSeats;
	 
	 private int availSeats;
	 
	 private int fare;

	public Car(int carMo, String cName, String cType, int totalSeats, int availSeats, int fare) {
		super();
		this.carMo = carMo;
		this.cName = cName;
		this.cType = cType;
		this.totalSeats = totalSeats;
		this.availSeats = availSeats;
		this.fare = fare;
	}

	public int getCarMo() {
		return carMo;
	}

	public void setCarMo(int carMo) {
		this.carMo = carMo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailSeats() {
		return availSeats;
	}

	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Car [carMo=" + carMo + ", cName=" + cName + ", cType=" + cType + ", totalSeats=" + totalSeats
				+ ", availSeats=" + availSeats + ", fare=" + fare + "]";
	}
	 

}
