package empie.pie.SpringBootCourse.courses.repository;

import empie.pie.SpringBootCourse.courses.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
