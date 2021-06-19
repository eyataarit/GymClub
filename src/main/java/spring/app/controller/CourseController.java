package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.app.model.Course;
import spring.app.service.CourseService;

import java.util.List;

@Controller
@RestController
@RequestMapping()
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {

        this.courseService = courseService;
    }

    @GetMapping(value = "getAllCourse")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();
    }

    @PostMapping(value = "saveCourse")
    public void saveCourse(@RequestBody Course course ){
        courseService.saveCourse(course);
        System.out.println("Course saved");
    }
    @DeleteMapping(path = "deleteCourse{courseId}")
    public void deleteCourseById(
            @PathVariable(value = "courseId") Long courseId){
        courseService.deleteCourseById(courseId);
        System.out.println("Course deleted");
    }

    @PutMapping(path = "updateCourse{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = false) String name ,
            @RequestParam(required = false) Double nbrHours,
            @RequestParam(required = false) Double tarifHour,
            @RequestParam (required = false) Integer capacity) {
        courseService.updateCourse(courseId,name,nbrHours,tarifHour,capacity);
    }

}
