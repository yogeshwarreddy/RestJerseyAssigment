package me.yogeshwar.au.jersey.employeecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.yogeshwar.au.jersey.employeecrud.models.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDaoImpl.
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/** The con. */
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeCRUD", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";
		List<Employee> list = new ArrayList<>();
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
					list.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where id=?";
		Employee employee = null;
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				rs.next();
				employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	/* (non-Javadoc)
	 * @see me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao#saveEmployee(me.yogeshwar.au.jersey.employeecrud.models.Employee)
	 */
	@Override
	public boolean saveEmployee(Employee employee) {
		String sql = "insert into employee(name,phone) values(?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getPhone());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao#updateEmployee(me.yogeshwar.au.jersey.employeecrud.models.Employee)
	 */
	@Override
	public boolean updateEmployee(Employee employee) {
		String sql = "update employee set name=?,phone=? where id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getPhone());
			stmt.setInt(3, employee.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see me.yogeshwar.au.jersey.employeecrud.dao.EmployeeDao#deleteEmployee(me.yogeshwar.au.jersey.employeecrud.models.Employee)
	 */
	@Override
	public boolean deleteEmployee(Employee employee) {
		String sql = "delete from employee where id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, employee.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
