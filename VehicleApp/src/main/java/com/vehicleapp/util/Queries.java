package com.vehicleapp.util;

public class Queries {

	public static final String CREATEQUERY = "create table car (modelname varchar(20), modelid integer primary key auto_increment,  modelprice double, brandname varchar(10), brandId int)";
	public static final String INSERTQUERY = "insert into car(modelname, modelprice,brandname,brandId) values(?,?,?,?)";
	public static final String UPDATEQUERY = "update car set modelprice=? where modelid=?";
	public static final String QUERYBYID = "select * from car where modelid=?";
	public static final String GETALLQUERY = "select * from car";
	public static final String DELETEBYID = "delete from car where modelid=?";
	public static final String QUERYBYBrandname = "select * from car where brandname=?";
	public static final String QUERYBYBrandnameModelname = "select * from car where brandname=? and modelname=?";
	public static final String QUERYBYBrandnameModelprice = "select * from car where brandname=? and modelprice<=?";

}
