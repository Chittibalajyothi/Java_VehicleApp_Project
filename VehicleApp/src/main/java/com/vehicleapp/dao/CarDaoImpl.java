package com.vehicleapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vehicleapp.exceptions.CarNotFoundException;
import com.vehicleapp.model.Car;
import com.vehicleapp.util.DbConnection;
import com.vehicleapp.util.Queries;


public class CarDaoImpl implements ICarDao {

	@Override
	public void addCar(Car car) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERTQUERY);) {
			preparedStatement.setString(1, car.getModelname());
			preparedStatement.setDouble(2, car.getModelprice());
			preparedStatement.setString(3, car.getBrandname());
			preparedStatement.setInt(4, car.getBrandId());
			preparedStatement.execute();
			System.out.println("Car added sucesfully");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateCar(int modelid, double modelprice) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			preparedStatement.setDouble(1, modelprice);
			preparedStatement.setInt(2, modelid);
			preparedStatement.execute();
			System.out.println("Car updated sucesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car getById(int modelid) {
		Car car = new Car();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			preparedStatement.setInt(1, modelid);
			try (ResultSet rt = preparedStatement.executeQuery();) {
				while (rt.next()) {

					String name = rt.getString("modelname");
					Double price = rt.getDouble("modelprice");
					String brandname = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					car.setModelname(name);
					car.setModelprice(price);
					car.setBrandname(brandname);
					car.setBrandId(brandId);
					System.out.println("Car found");
					System.out.println(car.toString());
				}
				return car;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteCar(int modelid) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETEBYID);) {
			preparedStatement.setInt(1, modelid);
			preparedStatement.execute();
			System.out.println("Car  id: " + modelid + " deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Car> getAllCars() {

		List<Car> carList = new ArrayList<Car>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETALLQUERY);) {
			try (ResultSet carResultSet = preparedStatement.executeQuery();) {
				while (carResultSet.next()) {

					String name = carResultSet.getString("modelname");
					Double price = carResultSet.getDouble("modelprice");
					String brandname = carResultSet.getString("brandname");
					int brandId = carResultSet.getInt("brandId");
					int modelid = carResultSet.getInt("modelid");
					Car car = new Car(name, modelid, price, brandname, brandId);

					carList.add(car);
					System.out.println(car.toString());
				}
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> getByBrandname(String brandname) throws CarNotFoundException {
		List<Car> carList = new ArrayList<Car>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandname);) {

			ps.setString(1, brandname);
			System.out.println("cars with brandname: " + brandname);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelid = rt.getInt("modelid");
					Car car = new Car(name, modelid, price, brandName, brandId);
					carList.add(car);
					System.out.println(car.toString());
				}
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> getByBrandnameAndModelname(String brandname, String modelname) throws CarNotFoundException {
		List<Car> carList = new ArrayList<Car>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandnameModelname);) {

			ps.setString(1, brandname);
			ps.setString(2, modelname);
		
			System.out.println("cars with modelname: " + modelname + " and  brandname: " + brandname);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelid = rt.getInt("modelid");
					Car car = new Car(name, modelid, price, brandName, brandId);
					carList.add(car);
					System.out.println(car.toString());
				}
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> getByBrandnameAndModelprice(String brandname, double modelprice) throws CarNotFoundException {
		List<Car> carList = new ArrayList<Car>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandnameModelprice);) {

			ps.setString(1, brandname);
			ps.setDouble(2, modelprice);
			System.out
					.println("cars with brandnames: " + brandname + " and  modelprices: " + modelprice);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelid = rt.getInt("modelid");
					Car car = new Car(name, modelid, price, brandName, brandId);
					carList.add(car);

					System.out.println(car.toString());
				}
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
