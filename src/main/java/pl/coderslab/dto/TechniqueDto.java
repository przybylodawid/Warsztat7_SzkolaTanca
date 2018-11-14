package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class TechniqueDto {
    @NotEmpty
    private String techniqueName;


    // ------------------------------------------
    // -------------- constructors --------------
    // ------------------------------------------

    // ------------------------------------------
    // ---------- getters and setters------------
    // ------------------------------------------


    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

}
