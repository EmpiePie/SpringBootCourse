package empie.pie.SpringBootCourse.courses.controller;

import empie.pie.SpringBootCourse.courses.bean.Course;
import empie.pie.SpringBootCourse.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return repository.findAll();
        //return Arrays.asList(new Course(1, "Microservices", "Johnny Smith"));
    }

    @GetMapping("/courses/{id}")
    public Course getCourseDetails(@PathVariable long id){
        Optional<Course> course = repository.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course not found with id " + id);
        }
        return course.get();
    }

    @PostMapping("/courses")
    public void createCourse (@RequestBody Course course){
        repository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse (@PathVariable long id, @RequestBody Course course){
        repository.save(course);
    }



    //GET - Retrieve Information (/courses, /courses/1)
    //POST - Create New Resources (/courses)
    //PUT - Update/Replace Resources (/courses/1)
    //PATCH - Update Part of the Resource (/courses/1)
    //DELETE - Delete a Resource (/courses/1)

}
