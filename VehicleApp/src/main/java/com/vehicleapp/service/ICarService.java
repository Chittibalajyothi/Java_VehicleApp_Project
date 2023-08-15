package com.vehicleapp.service;

import java.util.List;

import com.vehicleapp.exceptions.CarNotFoundException;
import com.vehicleapp.model.Car;



public interface ICarService {

	void addCar(Car car);
	void updateCar(int modelid, double modelprice);
	Car getById(int modelid);
	void deleteCar(int modelid);
	List<Car> getAllCars();
	List<Car> getByBrandname(String brandname) throws CarNotFoundException;
	List<Car> getByBrandnameAndModelname(String brandname, String modelname) throws CarNotFoundException;
	List<Car> getByBrandnameAndModelprice(String brandname, double modelprice) throws CarNotFoundException;

}
