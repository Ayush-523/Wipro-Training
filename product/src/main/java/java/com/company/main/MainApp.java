package com.company.main;

import java.util.Scanner;

import java.com.company.dao.ProductDAO;
import java.com.company.model.Product;

public class MainApp {
	public static void main(String[] args)
	{
		
		ProductDAO dao = new ProductDAO();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		System.out.println("\n1. Add product");
		System.out.println("2. View product");
		System.out.println("3. Update product");
		System.out.println("4. Delete product");
		System.out.println("5. Exit");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter price");
			double price = sc.nextDouble();
			
			dao.addProduct(new Product(name, price));
			
		case 2:
			dao.getAllProducts();
		case 5:
			System.exit(0);
		}
		}
		
	}

}