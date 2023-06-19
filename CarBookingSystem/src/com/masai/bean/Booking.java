package com.masai.bean;

public class Booking {
private int cId;
	
	private int cusId;
	
	private int carMo;
	
	private int carFrom;
	
	private int carTo;
	
	private boolean status;

	public Booking(int cId, int cusId, int carMo, int carFrom, int carTo, boolean status) {
		super();
		this.cId = cId;
		this.cusId = cusId;
		this.carMo = carMo;
		this.carFrom = carFrom;
		this.carTo = carTo;
		this.status = status;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getCarMo() {
		return carMo;
	}

	public void setCarMo(int carMo) {
		this.carMo = carMo;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [cId=" + cId + ", cusId=" + cusId + ", carMo=" + carMo + ", carFrom=" + carFrom + ", carTo="
				+ carTo + ", status=" + status + "]";
	}

	
	

}
