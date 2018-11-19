package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Returns List of courses where user is already Signed In

    @Query("SELECT c FROM Course c JOIN  c.users u WHERE u.id=:id")
    List<Course> findAllCoursesWhereUserIn(@Param("id")Long id);

    // Returns List of courses where user is not signed

    @Query("SELECT c FROM Course c JOIN  c.users u WHERE u.id<>:id")
    List<Course> findAllCoursesWhereUserNotIn(@Param("id")Long id);

}
