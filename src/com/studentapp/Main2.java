package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("******* Student Management System *******");
		System.out.println("******* Welcome *******");

		studentList = new ArrayList<Student>();

		Student s1 = new Student("Neha Raj", 22, "S-21");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("Python");

		Student s2 = new Student("Uday", 24, "S-11");
		s2.enrollCourse("Java");

		Student s3 = new Student("Ritu", 25, "S-15");
		s3.enrollCourse("DevOps");

		Student s4 = new Student("Abey", 29, "S-18");
		s4.enrollCourse("DSA");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);

		Student result = findStudentById("S-11");
		System.out.println("Result: " + result);
		sortByName();

	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found"));

		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		return result;
	}

	private static void sortByName() {
		Comparator<Student> studentComparator= (o1,o2)-> o1.getName().compareTo(o2.getName());
				
				
				
				/*new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		*/
		Collections.sort(studentList, studentComparator);
		System.out.println(studentList);
	}

}
