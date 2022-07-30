
package com.portfolio.sorayafp.DTOs;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class SkillDTO implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idSkill;
    private String nombreSkill ;
    private String imgSkill;
    private String porcentajeSkill;
    
    //Constructores

    public SkillDTO(String nombreSkill, String imgSkill, String porcentajeSkill) {
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
        this.porcentajeSkill = porcentajeSkill;
    }

    public SkillDTO() {
    }
    
    
}
