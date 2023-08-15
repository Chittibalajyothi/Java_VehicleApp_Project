package com.vehicleapp.service;

import java.util.List;

import com.vehicleapp.dao.CarDaoImpl;
import com.vehicleapp.dao.ICarDao;
import com.vehicleapp.exceptions.CarNotFoundException;
import com.vehicleapp.model.Car;



public class CarServiceImpl implements ICarService {

	ICarDao carService =new CarDaoImpl();
	
	@Override
	public void addCar(Car car) {
		carService.addCar(car);
	}

	@Override
	public void updateCar(int modelid, double modelprice) {
		carService.updateCar(modelid, modelprice);
	}

	@Override
	public Car getById(int modelid) {
		return carService.getById(modelid);
	}

	@Override
	public void deleteCar(int modelid) {
		carService.deleteCar(modelid);
	}

	@Override
	public List<Car> getAllCars() {
	
		return carService.getAllCars();
	}

	@Override
	public List<Car> getByBrandname(String brandname) throws CarNotFoundException {
		return carService.getByBrandname(brandname);
	}

	@Override
	public List<Car> getByBrandnameAndModelname(String brandname, String modelname) throws CarNotFoundException {
		return carService.getByBrandnameAndModelname(brandname, modelname);
	}

	@Override
	public List<Car> getByBrandnameAndModelprice(String brandname, double modelprice) throws CarNotFoundException {
		return carService.getByBrandnameAndModelprice(brandname, modelprice);
	}

}
