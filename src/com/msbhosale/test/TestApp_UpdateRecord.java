package com.msbhosale.test;

import com.msbhosale.beans.Student;
import com.msbhosale.dao.StudentDAO;

public class TestApp_UpdateRecord {

	public static void main(String[] args) {

		Student student = new Student(102, "Vinu", "Katkar");

		StudentDAO sd = new StudentDAO();
		sd.updateRecord(student.getRollNumber(), student.getFirstName(),
				student.getLastName());
	}
}