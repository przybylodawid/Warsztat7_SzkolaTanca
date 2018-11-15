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
    private Set<User> users;


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
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(@NotNull Set<User> users) {
        this.users = users;
    }
}
