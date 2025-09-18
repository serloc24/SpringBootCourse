package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager
    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        if(tempInstructor != null){
            return tempInstructor;
        }else throw new RuntimeException();
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tempInstructor.getCourses();

        for(Course c : courses){
            c.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        if(tempInstructorDetail != null){
            return tempInstructorDetail;
        }else throw new RuntimeException();    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        //remove the associated object reference
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);


    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        TypedQuery<Course> query = entityManager.createQuery(
                "FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        //execute the query
        return query.getResultList();

    }

    @Override
    public Instructor findInstructorWithCoursesFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i " +
                                                                    "JOIN FETCH i.courses " +
                                                                    "JOIN FETCH i.instructorDetail " +
                                                                    "WHERE i.id = :data", Instructor.class);
        query.setParameter("data",theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);

    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        entityManager.remove(entityManager.find(Course.class, theId));
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c from Course c JOIN FETCH c.reviews WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        return query.getSingleResult();
    }


}
