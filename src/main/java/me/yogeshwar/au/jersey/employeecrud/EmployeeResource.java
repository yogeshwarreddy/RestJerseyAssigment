package me.yogeshwar.au.jersey.employeecrud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao;
import me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDaoImpl;
import me.yogeshwar.au.jersey.employeecrud.models.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeResource.
 */
@Path("/employees")
public class EmployeeResource {

	/** The employee dao. */
	static EmployeeDao employeeDao = new EmployeeDaoImpl();

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee by id
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return the response builder
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseBuilder saveEmployee(Employee employee) {
		System.out.println(employee);
		if (employeeDao.saveEmployee(employee)) {
			return Response.accepted();
		} else {
			return Response.serverError();
		}
	}

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @return the response builder
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseBuilder updateEmployee(Employee employee) {
		System.out.println(employee);
		if (employeeDao.updateEmployee(employee)) {
			return Response.accepted();
		} else {
			return Response.serverError();
		}
	}

	/**
	 * Delete employee.
	 *
	 * @param employee the employee
	 * @return the response builder
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseBuilder deleteEmployee(Employee employee) {
		System.out.println(employee);
		if (employeeDao.deleteEmployee(employee)) {
			return Response.accepted();
		} else {
			return Response.serverError();
		}
	}
}
