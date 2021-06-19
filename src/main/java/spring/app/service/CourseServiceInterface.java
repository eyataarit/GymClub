package spring.app.service;

import spring.app.model.Course;

import java.util.List;

public interface CourseServiceInterface {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(Long id);
    void deleteCourseById(Long id);
    public void updateCourse(Long courseId, String courseName, Double nbrHours, Double tarifHour, Integer capacity);
}
