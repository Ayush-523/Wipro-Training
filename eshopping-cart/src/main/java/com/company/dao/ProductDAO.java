package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.company.model.Product;
import com.company.util.DBConnection;

public class ProductDAO {

	public void addProduct(Product p)
	{
	String sql = "insert into products(name ,price) values(? ,?)"; 
	
	String sql1 = "create table abc(id int)";  
	
	
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql))
	
	{
		ps.setString(1,p.getName());
		ps.setDouble(2, p.getPrice());
		ps.executeUpdate();
		System.out.println("Data added ");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	
	
	public void getAllProducts()
	{
	String sql = "select * from products";
	try(Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			)
	
	{
		while(rs.next())
		{
			System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " +rs.getDouble("price"));
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public void updateProduct(Product p)
	{
	    String sql = "update products set name = ?, price = ? where id = ?";

	    try(Connection conn = DBConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql))
	    {
	        ps.setString(1, p.getName());
	        ps.setDouble(2, p.getPrice());
	        ps.setInt(3, p.getId());

	        int rows = ps.executeUpdate();
	        if(rows > 0)
	        {
	            System.out.println("Product updated successfully");
	        }
	        else
	        {
	            System.out.println("Product not found");
	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	public void deleteProduct(int id)
	{
	    String sql = "delete from products where id = ?";

	    try(Connection conn = DBConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql))
	    {
	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();
	        if(rows > 0)
	        {
	            System.out.println("Product deleted successfully");
	        }
	        else
	        {
	            System.out.println("Product not found");
	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
}