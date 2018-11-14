package pl.coderslab.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="techniques")
public class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String techniqueName;

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

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technique technique = (Technique) o;
        return Objects.equals(id, technique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
