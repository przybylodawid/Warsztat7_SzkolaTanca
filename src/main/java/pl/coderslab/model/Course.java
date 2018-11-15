package pl.coderslab.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
    private LocalTime hour;
    @ManyToOne
    private Technique technique;

    @ManyToMany
    @Column(nullable = true)
    private Set<User> teachers;

    @ManyToMany
    @Column(nullable = true)
    private Set<User> students;

    // ------------------------------------------
    // -------------- constructors --------------
    // ------------------------------------------

    // ------------------------------------------
    // ---------- getters and setters------------
    // ------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    public Set<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<User> teachers) {
        this.teachers = teachers;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }
}
