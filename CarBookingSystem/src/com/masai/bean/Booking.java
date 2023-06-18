package com.masai.bean;

public class Booking {
private int cId;
	
	private int cusId;
	
	private int carMo;
	
	private int seatFrom;
	
	private int seatTo;
	
	private boolean status;

	public Booking(int cId, int cusId, int carMo, int seatFrom, int seatTo, boolean status) {
		super();
		this.cId = cId;
		this.cusId = cusId;
		this.carMo = carMo;
		this.seatFrom = seatFrom;
		this.seatTo = seatTo;
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

	public void setCarMod(int carMod) {
		this.carMo = carMod;
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
		return "Booking [cId=" + cId + ", cusId=" + cusId + ", carMo=" + carMo + ", seatFrom=" + seatFrom
				+ ", seatTo=" + seatTo + ", status=" + status + "]";
	}
	

}
