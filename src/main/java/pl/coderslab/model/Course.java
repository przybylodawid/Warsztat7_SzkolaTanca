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
    private Set<User> teachers;

    @ManyToMany
    private Set<User> students;
}
