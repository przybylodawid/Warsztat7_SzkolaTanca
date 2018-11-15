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
    @ManyToOne (fetch = FetchType.EAGER)
    private Technique technique;

    @ManyToMany (fetch = FetchType.EAGER)
    @Column
    private Set<User> users;



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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
