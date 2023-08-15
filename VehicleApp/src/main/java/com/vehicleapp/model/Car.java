package com.vehicleapp.model;

public class Car {
	private String modelname;
	private int modelid;
	private double modelprice;
	private String brandname;
	private int brandId;
	public Car() {
		super();
	}
	public Car(String modelname, int modelid, double modelprice, String brandname, int brandId) {
		super();
		this.modelname = modelname;
		this.modelid = modelid;
		this.modelprice = modelprice;
		this.brandname = brandname;
		this.brandId = brandId;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public int getModelid() {
		return modelid;
	}
	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	public double getModelprice() {
		return modelprice;
	}
	public void setModelprice(double modelprice) {
		this.modelprice = modelprice;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	@Override
	public String toString() {
		return "Car [modelname=" + modelname + ", modelid=" + modelid + ", modelprice=" + modelprice + ", brandname="
				+ brandname + ", brandId=" + brandId + "]";
	}
	
}
