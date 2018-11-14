package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.model.Role;
import pl.coderslab.model.Technique;

import java.util.Set;

public class UserDto {


    private String firstName;
    private String lastName;
    @NotEmpty
    private String email;
    private String note;
    private int tokens;
    @NotEmpty
    private String password;
    private Set<Role> roles;
    private Set<Technique> techniques;

    // ------------------------------------------
    // -------------- constructors --------------
    // ------------------------------------------

    // ------------------------------------------
    // ---------- getters and setters------------
    // ------------------------------------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(Set<Technique> techniques) {
        this.techniques = techniques;
    }
}
