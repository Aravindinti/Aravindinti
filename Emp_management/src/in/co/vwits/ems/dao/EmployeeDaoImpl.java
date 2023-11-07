package in.co.vwits.ems.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.vwits.ems.model.Employee;
public class EmployeeDaoImpl  {
	
	private  List<Employee> employees;
	Employee e1=new Employee();
	Employee e2=new Employee();
	Employee e3=new Employee();
	public  EmployeeDaoImpl()
	{
		employees=new ArrayList<Employee>();
		
		e1.setId(1);
		e1.setName("Aravind");
		e1.setSalary(35000);	
		employees.add(e1);
		
		//Employee e2=new Employee();
		e2.setId(2);
		e2.setName("Kaif");
		e2.setSalary(36000);		
		employees.add(e2);
		
	//	Employee e3=new Employee();
		e3.setId(3);
		e3.setName("Rashmika");
		e3.setSalary(37000);	
		employees.add(e3);
		
		//System.out.println(employees);
		
	}
	 public void save() {
		 
	try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
			PreparedStatement psmt=con.prepareStatement("INSERT INTO tbl_employee2 VALUES(?,?,?)");
		)
	{
		psmt.setInt(1, e1.getId());
		psmt.setString(2,e1.getName());
		psmt.setInt(3, e1.getSalary());
		psmt.executeUpdate();
		
		
		
		psmt.setInt(1, e2.getId());
		psmt.setString(2,e2.getName());
		psmt.setInt(3, e2.getSalary());
		psmt.executeUpdate();
		
		psmt.setInt(1, e3.getId());
		psmt.setString(2,e3.getName());
		psmt.setInt(3, e3.getSalary());
		psmt.executeUpdate();

	}
	catch (SQLException e) {
		System.out.println("exception");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	

}
