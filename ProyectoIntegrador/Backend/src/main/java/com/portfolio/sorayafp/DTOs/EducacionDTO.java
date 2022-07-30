
package com.portfolio.sorayafp.DTOs;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter



public class EducacionDTO implements Serializable {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private int idEdu;
   private String nombreEdu;
   private String lugarEdu;
   private String fechaEdu;
   private String descripcionEdu;
   
   //Constructores

    public EducacionDTO(String nombreEdu, String lugarEdu, String fechaEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
    }

    public EducacionDTO() {
    }
   
   

}

