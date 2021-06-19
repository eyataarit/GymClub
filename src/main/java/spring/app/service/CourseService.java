package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.app.model.Course;
import spring.app.repository.CourseRepository;

import java.util.List;
import java.util.Optional;
@Configuration
@Service
public class CourseService
        implements CourseServiceInterface {

    @Autowired
   private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        Optional<Course> courseOptional = courseRepository
                .findByName( course.getName());
        if (courseOptional.isPresent())
        {
            throw new IllegalStateException("Course Already exists!");
        }
        courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        Course course = null;
        if (courseOptional.isPresent()) {
            course = courseOptional.get();
        }else
        {
            throw new RuntimeException("Course with id " + id + "is not found ")  ;
        }
        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        boolean exists= courseRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Course with id " + id + " does not exist"
            );
        }
        courseRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void updateCourse(Long courseId,
                             String name,
                             Double nbrHours,
                             Double tarifHour,
                             Integer capacity)
    {

    Course course = courseRepository.findById(courseId).orElseThrow(()-> new IllegalStateException("Course named " + name + "not found "));

    if ( name!= null && course.getName() != name ){
        course.setName(name);
    }

    if ( nbrHours!=null  && nbrHours > 0 && course.getNbrHours() != nbrHours ){
        course.setNbrHours(nbrHours);
    }
    if ( tarifHour != null &&  tarifHour >0 && tarifHour!= course.getTarifHour()  ){
        course.setTarifHour(tarifHour);
    }
    if ( capacity >0 && capacity!= course.getCapacity()  ){
            course.setCapacity(capacity);
        }

    }
}
