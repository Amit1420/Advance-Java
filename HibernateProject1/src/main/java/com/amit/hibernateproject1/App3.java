package com.amit.hibernateproject1;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.amit.hibernateproject1.entity.Course;
import com.amit.hibernateproject1.entity.Student;
import com.amit.hibernateproject1.repository.CourseRepository;

public class App3 {
public static void main(String[] args) {
		
		Student student = new Student("Darshit", Date.valueOf(LocalDate.of(1995, 03, 11)));
		Student student2 = new Student("Jash", Date.valueOf(LocalDate.of(1998, 4, 05)));
		Student student3 = new Student("Rakesh", Date.valueOf(LocalDate.of(1999, 5, 20)));
		Student student4 = new Student("Subash", Date.valueOf(LocalDate.of(1995, 6, 25)));
		
		List<Student> students = new ArrayList<>();
		students.add(student);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		
		Course course = new Course("J2EE", 25);
		Course course2 = new Course("CORE", 90);
		Course course3 = new Course("Framework", 35);
		
		course.setStudents(students);
		course2.setStudents(students);
		course3.setStudents(students);
		
		List<Course> courses = new ArrayList<>();
		courses.add(course);
		courses.add(course2);
		courses.add(course3);
		
		student.setCourses(courses);
		student2.setCourses(courses);
		student3.setCourses(courses);
		student4.setCourses(courses);
		
		CourseRepository repository = new CourseRepository();
		repository.saveAllCourse(courses);
		
//		repository.deleteCourse(1);
		
	}

}
