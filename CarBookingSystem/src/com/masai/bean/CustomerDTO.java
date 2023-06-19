package com.masai.bean;

public class CustomerDTO {
	private int CId;

	private String firstName;
	
	private String lastName;
	
	private String mobile;
	
	private int carMo;
	private String cName;
	private int fare;
	private String tillDate;
	private String availiableTo;
	private boolean status;
	private int carFrom;
	private int carTo;
	public CustomerDTO(int cId, String firstName, String lastName, String mobile, int carMo, String cName, int fare,
			String tillDate, String availiableTo, boolean status, int carFrom, int carTo) {
		super();
		CId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.carMo = carMo;
		this.cName = cName;
		this.fare = fare;
		this.tillDate = tillDate;
		this.availiableTo = availiableTo;
		this.status = status;
		this.carFrom = carFrom;
		this.carTo = carTo;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCarFrom() {
		return carFrom;
	}
	public void setCarFrom(int carFrom) {
		this.carFrom = carFrom;
	}
	public int getCarTo() {
		return carTo;
	}
	public void setCarTo(int carTo) {
		this.carTo = carTo;
	}
	@Override
	public String toString() {
		return "CustomerDTO [CId=" + CId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", carMo=" + carMo + ", cName=" + cName + ", fare=" + fare + ", tillDate=" + tillDate
				+ ", availiableTo=" + availiableTo + ", status=" + status + ", carFrom=" + carFrom + ", carTo=" + carTo
				+ "]";
	}
	
	
	
	 

}
