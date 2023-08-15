package com.vehicleapp.client;

import java.util.Scanner;
import com.vehicleapp.model.Car;
import com.vehicleapp.service.CarServiceImpl;
import com.vehicleapp.service.ICarService;

public class CarMain {

	public static void main(String[] args) {
	
        Scanner scanner = new Scanner(System.in);
		ICarService carService = new CarServiceImpl();
		
		System.out.println(" Please choose the below operations to perform: ");
		System.out.println(
				" 1. Add Car\n 2. Update Car \n 3. Get Cars By CarID's \n 4. Get All Cars \n 5. Delete Car By Id\n 6. Get Car By Brandname\n 7. Get Car By Brandname And By Modelname\n 8. Get Car By Brandname And By Modelprice");
		int choice = scanner.nextInt();
		if (choice == 1) {
			scanner.nextLine();
			System.out.println("Enter modelname: ");
			String name = scanner.nextLine();
			System.out.println("Enter modelid: ");
			int modelid = scanner.nextInt();
			System.out.println("Enter modelprice: ");
			Double price = scanner.nextDouble();
			System.out.println("Enter brandname: ");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			System.out.println("Enter brandId: ");
			int brandId = scanner.nextInt();
	        Car car = new Car(name, modelid,price,brandname,brandId);
			carService.addCar(car);
			
		} else if (choice == 2) {
			System.out.println("Enter carId to update price");
			int id = scanner.nextInt();
			System.out.println("Enter new price to add car");
			int modelprice= scanner.nextInt();
			carService.updateCar(id, modelprice);
			
		} else if (choice==3) {
			System.out.println("Enter modelid to see cars");
			int id = scanner.nextInt();
			carService.getById(id);
			
		} else if (choice==4) {
			carService.getAllCars();
			
		} else if (choice==5) {
			
			System.out.println("Enter carId to delete car");
			
			int id = scanner.nextInt();
			carService.deleteCar(id);	
			
			
		} else if (choice==6) {
			System.out.println("Enter car brandname to fetch car");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			carService.getByBrandname(brandname);
		} else if (choice==7) {
			System.out.println("Enter car brandname and modelname to see cars");
			System.out.println("brandnames: ");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			System.out.println("Enter modelname: "); 
			String modelname = scanner.nextLine();
			
			carService.getByBrandnameAndModelname(brandname, modelname);
		} else {
			System.out.println("Enter car brandname and modelprice to see cars");
			System.out.println("Brandnames: ");
			scanner.nextLine();
			String brandnames = scanner.nextLine();
			System.out.println("Enter modelprice: ");
			Double modelprice = scanner.nextDouble();
			carService.getByBrandnameAndModelprice(brandnames, modelprice);
		}
		scanner.close();


	}

	}
