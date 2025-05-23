package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Entity.Course;
import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;
import com.luv2code.cruddemo.Entity.Review;
import com.luv2code.cruddemo.dao.AppDAO;
import jakarta.transaction.Transactional;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithJoinFetch(appDAO);

//			updateInstructor(appDAO);
//			updateCourse(appDAO);

//			deleteInstructorById(appDAO);
//			deleteCourse(appDAO);
//			addCourseAndReview(appDAO);
//			retrieveCourseAndReviews(appDAO);
			deleteCourseAndReview(appDAO);
		};
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		System.out.println("Deleting course");
		int theId = 10;
		appDAO.deleteCourseAndReviewsByCourseId(10);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println("Course :" + course);
		System.out.println("Reviews :" + course.getReview());
	}

	private void addCourseAndReview(AppDAO appDAO) {
		Course course = new Course("How to be a hot Youtuber");

		Review review1 = new Review("Good course");
		Review review2 = new Review("Awesome course");
		Review review3 = new Review("Great course");

		course.addReview(review1);
		course.addReview(review2);
		course.addReview(review3);

		appDAO.save(course);

		System.out.println("DONE");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Delete Course with id: " + theId);
		appDAO.deleteCourseById(theId);
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course course = appDAO.findCourseById(theId);
		course.setTitle("To be a hot Youtuber");

		appDAO.update(course);
		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor instructor = appDAO.findById(theId);
		instructor.setEmail("helloworld@gmail.com");
		appDAO.update(instructor);

	}

	private void findInstructorWithJoinFetch(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor = " + tempInstructor);
		System.out.println("Courses = " + tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findById(1);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("The associate courses :" + tempInstructor.getCourses());
	}



	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor with ID: " + theId);
		Instructor tempInstructor = appDAO.findById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associate courses :" + tempInstructor.getCourses());
		System.out.println("DONE");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Susan", "Public", " susan@luv2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("youtube.com/ihavenoidea", "maybe love to code!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("Become Hot Tiktoker");
		Course course2 = new Course("Become Viral On Social Media");

		tempInstructor.addCourse(course1);
		tempInstructor.addCourse(course2);
		System.out.println("Saving Instructor " + tempInstructor);
		System.out.println("Courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("DONE");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor Detail with id = " + theId);
		InstructorDetail instructorDetailTemp = appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Detail = " + instructorDetailTemp);
		System.out.println("Associated Instructor: " + instructorDetailTemp.getInstructor());
		System.out.println("I'm done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Delete instructor with id " + theId);
		appDAO.deleteById(2);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;

		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("The associated instructorDetail only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor =
//				new Instructor("Chad", "Darby", "darby@luv2code.com");
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("youtube.com/lub2code", "love to code!!");

		Instructor tempInstructor =
				new Instructor("Nghia", "Le", " nghiale@luv2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("youtube.com/ihavenoidea", "maybe love to code!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
