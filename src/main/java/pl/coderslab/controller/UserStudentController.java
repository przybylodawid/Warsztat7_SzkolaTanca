package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Helper;
import pl.coderslab.model.Course;
import pl.coderslab.model.User;
import pl.coderslab.repositories.CourseRepository;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserStudentController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String goHome(){
        return "home";
    }

    @RequestMapping("/all")
    public String show(Model model, HttpServletRequest request) {
        Long id = Helper.getUserFromSession(request).getId();
        List<Course> coursesin = courseRepository.findAllCoursesWhereUserIn(id);
        model.addAttribute("coursesin", coursesin);

        List<Course> allcourses = courseRepository.findAll();
        List<Course> coursesnotin = new ArrayList<>();
        for (Course course : allcourses) {

            Set<User> users = course.getUsers();
            boolean isIn = false;
            for (User user : users) {
                if (user.getId() == id) {
                  isIn= true;
                }
            }
            if (isIn == false) {
                coursesnotin.add(course);
            }
        }

        model.addAttribute("coursesnotin", coursesnotin);

        return "userCourses";
    }

    @RequestMapping("/signmein/{course_id}")
    public String signUserToCourse(@PathVariable Long course_id, HttpServletRequest request){
        Long user_id = Helper.getUserFromSession(request).getId();
        User user = userRepository.findOne(user_id);
        Course course = courseRepository.findOne(course_id);
        Set<User> users = course.getUsers();
        users.add(user);
        course.setUsers(users);

        courseRepository.save(course);

        return "redirect:/user/all";
    }

    @RequestMapping("/signmeout/{course_id}")
    public String signOutUserToCourse(@PathVariable Long course_id, HttpServletRequest request){
        Long user_id = Helper.getUserFromSession(request).getId();
        User user = userRepository.findOne(user_id);
        Course course = courseRepository.findOne(course_id);
        Set<User> users = course.getUsers();
        users.remove(user);
        course.setUsers(users);

        courseRepository.save(course);

        return "redirect:/user/all";
    }
}
