package com.masai.bean;

public class Car {
	private int carMo;
	 
	 private String cName;
	  
	 private String cType;
	 private String tillDate;
	 
	 private String availiableTo;
	  
	 private int totalCars;
	 
	 private int availCars;
	 
	 private int fare;

	public Car(int carMo, String cName, String cType, String tillDate, String availiableTo, int totalCars,
			int availCars, int fare) {
		super();
		this.carMo = carMo;
		this.cName = cName;
		this.cType = cType;
		this.tillDate = tillDate;
		this.availiableTo = availiableTo;
		this.totalCars = totalCars;
		this.availCars = availCars;
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

	public String getTillDate() {
		return tillDate;
	}

	public void setTillDate(String tillDate) {
		this.tillDate = tillDate;
	}

	public String getAvailiableTo() {
		return availiableTo;
	}

	public void setAvailiableTo(String availiableTo) {
		this.availiableTo = availiableTo;
	}

	public int getTotalCars() {
		return totalCars;
	}

	public void setTotalCars(int totalCars) {
		this.totalCars = totalCars;
	}

	public int getAvailCars() {
		return availCars;
	}

	public void setAvailCars(int availCars) {
		this.availCars = availCars;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Car [carMo=" + carMo + ", cName=" + cName + ", cType=" + cType + ", tillDate=" + tillDate
				+ ", availiableTo=" + availiableTo + ", totalCars=" + totalCars + ", availCars=" + availCars + ", fare="
				+ fare + "]";
	}

	

}
