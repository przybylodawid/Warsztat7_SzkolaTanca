package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
