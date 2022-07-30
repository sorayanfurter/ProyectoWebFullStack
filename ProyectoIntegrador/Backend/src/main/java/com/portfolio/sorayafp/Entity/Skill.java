
package com.portfolio.sorayafp.Entity;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


 @Entity
 @Getter @Setter
  @Table(name="Skills")


public class Skill implements Serializable  {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int idSkill;
private String nombreSkill ;
private String imgSkill;
private String porcentajeSkill;


//Constructores

    public Skill(String nombreSkill, String imgSkill, String porcentajeSkill) {
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
        this.porcentajeSkill = porcentajeSkill;
        
    }

    public Skill() {
    }


 }


    

