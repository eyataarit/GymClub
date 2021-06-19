package spring.app.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.app.model.Course;

import java.util.Optional;
@Configuration
@Repository
public interface CourseRepository
    extends JpaRepository<Course,Long> {
    public Optional<Course> findByName(@Param("name") String name);
}
