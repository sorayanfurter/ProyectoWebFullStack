
package com.portfolio.sorayafp.DTOs;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDTO implements Serializable{
    
    @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String idExp;
    @NotBlank
    private String nombreExp ;
    @NotBlank
    private String lugarExp;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String descripcionExp;


    public ExperienciaDTO(String nombreExp, String lugarExp, String fechaExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.lugarExp = lugarExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
       
    }

    
    public ExperienciaDTO() {
    }
    
}
