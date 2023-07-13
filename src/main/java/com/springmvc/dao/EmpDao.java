package com.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springmvc.entity.Employee;
import com.springmvc.utilities.JDBCConnectionFactory;

@Component
public class EmpDao {
	Connection con = null;

	public EmpDao() {
		con = JDBCConnectionFactory.getJDBCConnection();
	}

	public boolean register(Employee e) {
		try {

			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSal());

			int result = ps.executeUpdate();
			if (result == 1)
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	public boolean update(int id, int age) {
		try {

			PreparedStatement ps = con.prepareStatement("update emp set age=? where id=?");
			ps.setInt(1, age);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee selectById(int id) {
		try {

			PreparedStatement ps = con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				return new Employee(i, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Employee> allRecords() {
		List<Employee> list = new ArrayList<>();
		try {

			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee e = new Employee(i, name, age);
				list.add(e);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteByID(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			if (result == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
