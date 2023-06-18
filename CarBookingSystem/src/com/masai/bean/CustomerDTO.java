package com.masai.bean;

public class CustomerDTO {
	private int CId;

	private String firstName;
	
	private String lastName;
	
	private String mobile;
	
	private int carMo;
	 
	 private String cName;
	 
	 private int fare;
	 
	 private int seatFrom;
	 
	 private int seatTo;
	 
	 private boolean status;

	public CustomerDTO(int cId, String firstName, String lastName, String mobile, int carMo, String cName, int fare,
			int seatFrom, int seatTo, boolean status) {
		super();
		CId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.carMo = carMo;
		this.cName = cName;
		this.fare = fare;
		this.seatFrom = seatFrom;
		this.seatTo = seatTo;
		this.status = status;
	}

	public int getCId() {
		return CId;
	}

	public void setCId(int cId) {
		CId = cId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getSeatFrom() {
		return seatFrom;
	}

	public void setSeatFrom(int seatFrom) {
		this.seatFrom = seatFrom;
	}

	public int getSeatTo() {
		return seatTo;
	}

	public void setSeatTo(int seatTo) {
		this.seatTo = seatTo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerDTO [CId=" + CId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", carMo=" + carMo + ", cName=" + cName + ", fare=" + fare + ", seatFrom=" + seatFrom + ", seatTo="
				+ seatTo + ", status=" + status + "]";
	}
	 

}
