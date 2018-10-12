package com.msbhosale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msbhosale.beans.Student;

public class StudentDAO {

	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
	private final String USER = "root";
	private final String PASSWORD = "root";

	public void saveRecord(int rollNumber, String firstName, String lastName) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(DATABASE_URL, USER,
					PASSWORD);
			PreparedStatement pst = con
					.prepareStatement("insert into student values (?,?,?)");

			pst.setInt(1, rollNumber);
			pst.setString(2, firstName);
			pst.setString(3, lastName);

			int updatedRows = pst.executeUpdate();

			System.out.println(updatedRows + " record added");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void updateRecord(int rollNumber, String firstName, String lastName) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(DATABASE_URL, USER,
					PASSWORD);
			PreparedStatement pst = con
					.prepareStatement("update student set first_name=?, last_name=? where roll_number=?");

			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setInt(3, rollNumber);

			int updatedRows = pst.executeUpdate();

			System.out.println(updatedRows + " record updated");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleteRecord(int rollNumber) {

	}

	public List getRecords() {

		List studentsList = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(DATABASE_URL, USER,
					PASSWORD);
			PreparedStatement pst = con
					.prepareStatement("select * from student");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Student student = new Student(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				studentsList.add(student);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return studentsList;
	}
}