import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.impl.EmployeeServiceImpl;
import in.co.vwits.service.EmployeeService;

public abstract class TestEmployee implements EmployeeService {
	
	
	public static void main(String[] args) {
		EmployeeService sao=new EmployeeServiceImpl();
		Scanner sc=null;
		
		try {
			
			System.out.println("<-----Employee Management System---->");
			System.out.println("--->1.Find all The Employees");
			System.out.println("--->2.Find all The Employee By ID");
			System.out.println("--->3.Insert New Employee Details");
			System.out.println("--->4.Delete Employee Details By ID");
			System.out.println("--->5.Update Salary of a Employee By Using ID");
			System.out.println("--->6.Sort Employees By  Names");
			System.out.println("--->7.Sort Employess By Salary");
			
			sc=new Scanner(System.in);
			int option =1;
			do {
				System.out.println();
				System.out.println("Enter option");
					option=sc.nextInt() ;
	switch (option) 
          {
	case 1: 
		 System.out.println("All Employee Details \n");
		          List<Employee> emp=sao.findAll();
	                System.out.println(emp);
	                break;
	case 2:
		System.out.println("Enter Employee ID \n");
		Optional<Employee> emp2=sao.findByID(sc.nextInt());
		System.out.println(emp2);
		break;
		
	case 3: 
		System.out.println("Enter Employee Details to Insert(ID,NAME,SALARY) \n ");
		Employee e=new Employee();
		e.setId(sc.nextInt());
		e.setName(sc.next());
		e.setSalary(sc.nextInt());
		sao.Insert(e);
		System.out.println("Inserted");
		break;
		
	case 4:
		System.out.println("Enter EmployeeID to Delete \n");
		sao.deleteById(sc.nextInt());
	       System.out.println("Deleted");
	       break;
	       
	case 5:
		System.out.println("Enter Employee ID to which U Want to Update salary \n");
		sao.UpdateBySalary(sc.nextInt(), sc.nextInt());
		break;
	 
	case 6:
		 System.out.println("enter 1 --> Sort Names in [Z-A] order /n 0--> Sort Names in [A-Z] order");		
		List<Employee> p=sao.sortingByName(sc.nextInt());
		System.out.println(p);
		break;
		
	case 7:
      System.out.println("enter 1 --> Sort Salary in Descending /n 0--> Sort Salary in Ascending");
		List<Employee> p2=sao.sortingBySalary(sc.nextInt());
		System.out.println(p2);
		break;
		
	case -1:
		System.out.println("Thank You");
		break;
		
					
				}
			 }
		while(option!=-1);
		
	}
	finally
	{
	sc.close();	
	}

	 
	}

}
