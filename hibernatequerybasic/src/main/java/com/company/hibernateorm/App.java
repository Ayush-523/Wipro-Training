package com.company.hibernateorm;

import com.company.hibernateorm.dao.CategoryDao;
import com.company.hibernateorm.dao.ProductDao;
import com.company.hibernateorm.entity.Category;
import com.company.hibernateorm.entity.Product;

public class App {

    public static void main(String[] args) {

        CategoryDao categoryDao =
                new CategoryDao();

        ProductDao dao =
                new ProductDao();

        Category electronics =
                new Category("Electronics");

        Category stationary =
                new Category("Stationary");

        Category poojaItems =
                new Category("Pooja Items");



        categoryDao.saveCategory(electronics);
        categoryDao.saveCategory(stationary);
        categoryDao.saveCategory(poojaItems);

        dao.saveProduct(
                new Product("Laptop",
                        75000,
                        electronics));

        dao.saveProduct(
                new Product("Mobile",
                        30000,
                        electronics));

        dao.saveProduct(
                new Product("Headphones",
                        2500,
                        electronics));

        dao.saveProduct(
                new Product("Notebook",
                        120,
                        stationary));

        dao.saveProduct(
                new Product("Pen",
                        20,
                        stationary));

        dao.saveProduct(
                new Product("Marker",
                        60,
                        stationary));

        dao.saveProduct(
                new Product("Agarbatti",
                        80,
                        poojaItems));

        dao.saveProduct(
                new Product("Diya",
                        150,
                        poojaItems));

        dao.saveProduct(
                new Product("Pooja Thali",
                        700,
                        poojaItems));

        System.out.println(
                "\nENTITY QUERY\n");

        dao.getAllProducts()
                .forEach(System.out::println);

        System.out.println(
                "\nPARAMETERIZED QUERY\n");

        dao.getProductsGreaterThan(5000)
                .forEach(System.out::println);

        System.out.println(
                "\nCRITERIA QUERY\n");

        dao.getProductsUsingCriteria()
                .forEach(System.out::println);
        System.out.println(
                "\nNATIVE QUERY\n");

        dao.getProductsUsingNativeQuery()
                .forEach(System.out::println);


        System.out.println(
                "\nMAXIMUM PRICE\n");

        System.out.println(
                dao.getMaximumPrice());
    }
}