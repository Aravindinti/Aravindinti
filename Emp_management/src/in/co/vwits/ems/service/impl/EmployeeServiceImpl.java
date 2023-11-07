package in.co.vwits.ems.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.service.EmployeeService;


public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDaoImpl dao;
	 
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		dao=new EmployeeDaoImpl();
	}
	
	//public List<String> sortingByName()
	//{
	//	return dao.findAll().stream().map(emp->emp.getName()).sorted().toList();
	//}
	public List<Employee> findAll()
	{
		List<Employee> employees=new ArrayList<>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
				PreparedStatement psmt=con.prepareStatement("SELECT * FROM  tbl_employee2 ");
			)
		{
			   ResultSet rs=psmt.executeQuery();
			    
			   while(rs.next())
			   {
				   Employee foundStudent =new Employee();
					
				   foundStudent.setId(rs.getInt(1));
				   foundStudent.setName(rs.getString(2));
				   foundStudent.setSalary(rs.getInt(3));
				   employees.add(foundStudent);
				   
				   }  
			   
			   
	}
		catch (SQLException e) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	
	}
	
	public Optional<Employee> findByID(int id)
	{
		
		//List<Employee> employees=new ArrayList<>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
				PreparedStatement psmt=con.prepareStatement("SELECT * FROM  tbl_employee2 where id=? ");
			)
		{
			psmt.setInt(1, id);		
			   ResultSet rs=psmt.executeQuery();
			   Employee foundStudent =new Employee();
			     if(rs.next())
			   {			 	
				   foundStudent.setId(rs.getInt(1));
				   foundStudent.setName(rs.getString(2));
				   foundStudent.setSalary(rs.getInt(3));
				   } 
			     return Optional.of(foundStudent);
		}
		catch (SQLException e) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return Optional.empty();
	
	}
	
	public void Insert(Employee e) {
		 
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
				PreparedStatement psmt=con.prepareStatement("INSERT INTO tbl_employee2 VALUES(?,?,?)");
			)
		{
			psmt.setInt(1, e.getId());
			psmt.setString(2,e.getName());
			psmt.setInt(3, e.getSalary());
			psmt.executeUpdate();
			
		}
		catch (SQLException ee) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		}
	
	public void deleteById(int id ) {
		 
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
				PreparedStatement psmt=con.prepareStatement(" DELETE FROM tbl_employee2 where id=? ");
			)
		{
			psmt.setInt(1, id);		
			 psmt.executeUpdate();
			
		}
		catch (SQLException ee) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		}

	public List<Employee> sortingByName(int key)
	{
		
			List<Employee> employees=new ArrayList<>();
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
					PreparedStatement psmt=con.prepareStatement("SELECT * FROM  tbl_employee2 ");
				)
			{
				   ResultSet rs=psmt.executeQuery();
				    
				   while(rs.next())
				   {
					   Employee foundStudent =new Employee() ;
					   foundStudent.setId(rs.getInt(1));
					   foundStudent.setName(rs.getString(2));
					   foundStudent.setSalary(rs.getInt(3));
					   employees.add(foundStudent);
					   
					   }  
				   
				   
		}
			catch (SQLException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Employee> names;
			if(key==0) {
		 names=employees.stream().sorted(Comparator.comparing(Employee::getName)).toList();
			}
			else
			{
				 names=employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();
			}
	 return names;	
	}
	
	public List<Employee> sortingBySalary(int key)
	{
		
			List<Employee> employees=new ArrayList<>();
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
					PreparedStatement psmt=con.prepareStatement("SELECT * FROM  tbl_employee2 ");
				)
			{
				   ResultSet rs=psmt.executeQuery();
				    
				   while(rs.next())
				   {
					   Employee foundStudent =new Employee() ;
					   foundStudent.setId(rs.getInt(1));
					   foundStudent.setName(rs.getString(2));
					   foundStudent.setSalary(rs.getInt(3));
					   employees.add(foundStudent);
					   
					   }  
		}
			catch (SQLException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Employee> names;
			if(key==0) {
		 names=employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).toList();
			}
			else
			{
				 names=employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).toList();
			}
	 return names;	
	}
	
	public void UpdateBySalary(int id,int salary)
	{
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db2","root","9492706012Aa#");	
				PreparedStatement psmt=con.prepareStatement("UPDATE tbl_employee2 SET salary =? WHERE id=?");
				)
		{
			psmt.setInt(1,salary);
			psmt.setInt(2,id);
			psmt.executeUpdate();
		
		}
		
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	
	/*public  void push()
	{
		dao.save();
	}
	*/
	
	

}
