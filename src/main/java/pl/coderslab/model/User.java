package pl.coderslab.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20)
    private String firstName;
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    private String note;
    private int tokens;
    private String password;

    @ManyToMany (cascade =  CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Role> roles;


    @ManyToMany (cascade =  CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Technique> techniques;



    // ------------------------------------------
    // -------------- constructors --------------
    // ------------------------------------------

    public User() {
    }

    // ------------------------------------------
    // ---------- getters and setters------------
    // ------------------------------------------

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setHashedPassword(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
