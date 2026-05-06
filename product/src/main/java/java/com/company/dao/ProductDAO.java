package java.com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import java.com.company.model.Product;
import java.com.company.util.DBConnection;

public class ProductDAO {

	public void addProduct(Product p)
	{
	String sql = "insert into products(name ,price) values(? ,?)"; // parameterized query
	
	String sql1 = "create table abc(id int)";  // static queries when there is no parameter
	
  // CallableStatement  -- calling procedure you created in mysql
	
	//try with resources
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
}