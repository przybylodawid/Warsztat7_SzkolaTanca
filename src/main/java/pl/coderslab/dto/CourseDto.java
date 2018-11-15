package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.model.Technique;
import pl.coderslab.model.User;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class CourseDto {

    @NotNull
    private String day;
    @NotNull
    private String hour;
    @NotNull
    private Technique technique;

    @NotNull
    private Set<User> teachers;

    private Set<User> students;

    // ------------------------------------------
    // -------------- constructors --------------
    // ------------------------------------------

    // ------------------------------------------
    // ---------- getters and setters------------
    // ------------------------------------------


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    @NotNull
    public Set<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(@NotNull Set<User> teachers) {
        this.teachers = teachers;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }
}
