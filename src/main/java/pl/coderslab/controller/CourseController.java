package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Helper;
import pl.coderslab.dto.CourseDto;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.Course;
import pl.coderslab.model.Technique;
import pl.coderslab.model.User;
import pl.coderslab.repositories.CourseRepository;
import pl.coderslab.repositories.TechniqueRepository;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TechniqueRepository techniqueRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public String showAllCourses(Model model){
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courseslist", courses);
        return "coursesShowAll";

    }
    @GetMapping("/add")
    private String showCourseAddForm(Model model){
        model.addAttribute("courseDto", new CourseDto());
        return "forms/courseAdd";
    }

    @PostMapping("/add")
    private String saveCourse(@Valid CourseDto courseDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/courseAdd";
        }

        Course course = new Course();
        course.setDay(courseDto.getDay());
        course.setHour(LocalTime.parse(courseDto.getHour()));

        course.setTechnique(courseDto.getTechnique());
        course.setUsers(courseDto.getUsers());

        courseRepository.save(course);

        return "redirect:/admin/courses/all";
    }

    @GetMapping("/edit/{id}")
    private String editCourse(@PathVariable Long id, Model model){
        Course course = courseRepository.findOne(id);
        model.addAttribute("course", course);

        return "forms/courseEdit";
    }

    @PostMapping("/edit/{id}")
    private String saveEditedCourse(@Valid Course course, @PathVariable Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/courseEdit";
        }

        course.setId(id);
        courseRepository.save(course);

        return "redirect:/admin/courses/all";
    }


    @RequestMapping("/delete/{id}")
    private String deleteUser(@PathVariable Long id){
        courseRepository.delete(courseRepository.getOne(id));
        return "redirect:/admin/courses /all";
    }



    @ModelAttribute("hours")
    public List<String> getHourList(){
        List<String> hours = new ArrayList<>();
        hours.add("18:00");
        hours.add("19:00");
        hours.add("20:00");
        hours.add("21:00");
        return hours;
    }
    @ModelAttribute("days")
    public List<String> getDayList(){
        List<String> days = new ArrayList<>();
        days.add("Poniedziałek");
        days.add("Wtorek");
        days.add("Środa");
        days.add("Czwartek");
        days.add("Piątek");
        days.add("Sobota");
        days.add("Niedziela");
        return days;
    }

    @ModelAttribute("teachers")
    public Set<User> getTeachers(){
        Set<User> teachers = techniqueRepository.findUserByRoleName("teacher");

    return teachers;
    }
    @ModelAttribute("techniques")
    public List<Technique> getTechniques(){
        List<Technique> techniques = techniqueRepository.findAll();
        return techniques;
    }
    @ModelAttribute("users")
    public Set<User> getUsers(){
        Set<User> users = techniqueRepository.findUserByRoleName("user");
        return users;
    }

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request){
        return Helper.getUserFromSession(request);
    }

    @ModelAttribute("isAdmin")
    public boolean checkIfAdmin(HttpServletRequest request){
        return Helper.checkIfAdmin(request);
    }
}
