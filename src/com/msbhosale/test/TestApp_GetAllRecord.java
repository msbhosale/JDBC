package com.msbhosale.test;

import java.util.Iterator;
import java.util.List;

import com.msbhosale.beans.Student;
import com.msbhosale.dao.StudentDAO;

public class TestApp_GetAllRecord {

	public static void main(String[] args) {

		StudentDAO sd = new StudentDAO();
		List studentsList = sd.getRecords();
		Iterator iterator = studentsList.iterator();

		while (iterator.hasNext()) {

			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
}