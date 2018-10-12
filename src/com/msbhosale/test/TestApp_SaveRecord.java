package com.msbhosale.test;

import com.msbhosale.beans.Student;
import com.msbhosale.dao.StudentDAO;

public class TestApp_SaveRecord {

	public static void main(String[] args) {

		Student student = new Student(102, "Vinayak", "Katkar");

		StudentDAO sd = new StudentDAO();
		sd.saveRecord(student.getRollNumber(), student.getFirstName(),
				student.getLastName());
	}
}