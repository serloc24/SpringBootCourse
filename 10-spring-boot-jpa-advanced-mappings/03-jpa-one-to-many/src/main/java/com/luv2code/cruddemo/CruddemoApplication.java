package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(String[] args, AppDAO appDAO){
		return runner ->
		{
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //findInstructorWithCoursesJoinFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            //deleteInstructor(appDAO);
            deleteCourseById(appDAO);

		};
	}

    private void deleteCourseById(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Course deleted!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Finding the course " + theId);
        Course tempCourse = appDAO.findCourseById(theId);
        tempCourse.setTitle("Enjoy the simple things");
        System.out.println("Changing the title to the course");
        appDAO.update(tempCourse);
        System.out.println("Change saved");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Updating instructor lastname: ");
        tempInstructor.setLastName("TESTER");
        appDAO.update(tempInstructor);
        System.out.println("Change updated");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor ..." );
        Instructor tempInstructor = appDAO.findInstructorWithCoursesFetch(theId);
        System.out.println(tempInstructor);
        System.out.println("With the courses: ");
        System.out.println(tempInstructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " +theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("TempInstructor: " +tempInstructor);

        //Find courses fetchType.LAZY
        System.out.println("Finding courses for this instructor");
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        //Associate courses
        tempInstructor.setCourses(courses);
        System.out.println(" The associated courses to this instructor are:");
        System.out.println(tempInstructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " +theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor: " +tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//Create instructor
		Instructor tempInstructor = new Instructor("Susan","Public","susan@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Play videogames");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//create Courses
		Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
		Course tempCourse2 = new Course("The Pinball MasterClass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//Save instructor
		System.out.println("Saving instructor --> " + tempInstructor);
		System.out.println("With this courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Instructor saved!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting InstructorDetail id: " + theId);
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("Deleted Instructor details");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructorDetail id: " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Details: "+ tempInstructorDetail);
		System.out.println("The associated Instructor: " + tempInstructorDetail.getInstructor());
	}


	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Instructor removed ");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("TempInstructor: "+ tempInstructor);
		System.out.println("The associated details: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		//create instructor
//		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Love to code");
//		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Play guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor --> " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Instructor saved!");
	}
}
