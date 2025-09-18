package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numDeleted = studentDAO.deleteAll();
		System.out.println("We deleted " + numDeleted + " rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer theId = 3;
		System.out.println("Deleting student id : " + theId);
		studentDAO.delete(theId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on th id
		int studentId = 1;
		System.out.println("Getting the student with ID: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to Scooby
		myStudent.setFirstName("John");
		//Update the student
		System.out.println("Updating the student....");
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: ");
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a new student..");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student, ID: " + theId);

		//retrieve student based on id
		System.out.println("Retrieving the student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display Student
		System.out.println("Found the student " + myStudent.toString());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3= new Student("Bonita","Applebum","bonita@luv2code.com");


		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


		//display id of the saved student
		System.out.println("The ID of the student 1 is: " + tempStudent1.getId());
		System.out.println("The ID of the student 2 is: " + tempStudent2.getId());
		System.out.println("The ID of the student 3 is: " + tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("The ID of the student is: " + tempStudent.getId());

	}

}
