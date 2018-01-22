package me.yogeshwar.au.jersey.employeecrud.dao;

import java.util.List;

import me.yogeshwar.au.jersey.employeecrud.models.Employee;
 
// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeDao.
 */
public interface EmployeeDao {

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	public List<Employee> getAllEmployees();

	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee by id
	 */
	public Employee getEmployeeById(int id);

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	public boolean saveEmployee(Employee employee);

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	public boolean updateEmployee(Employee employee);
	
	/**
	 * Delete employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	public boolean deleteEmployee(Employee employee);
}
