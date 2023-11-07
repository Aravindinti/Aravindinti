package in.co.vwits.service;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Optional<Employee> findByID(int id);
	public void Insert(Employee e);
	public void deleteById(int id );
	public List<Employee> sortingByName(int key);
	public List<Employee> sortingBySalary(int key);
	public void UpdateBySalary(int id,int salary);
	

}
