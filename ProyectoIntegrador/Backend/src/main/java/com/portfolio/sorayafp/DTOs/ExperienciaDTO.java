
package com.portfolio.sorayafp.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.portfolio.sorayafp.Entity.Usuario;
import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDTO implements Serializable{
    
   /* @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String idExp;*/
    @NotBlank
    private String nombreExp ;
    @NotBlank
    private String lugarExp;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String descripcionExp;
   /* @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idUsuario")
    private Usuario usuario;*/
    
    //Constructores

    public ExperienciaDTO(String nombreExp, String lugarExp, String fechaExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.lugarExp = lugarExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
       /* this.usuario = usuario;*/
    }

    

    public ExperienciaDTO() {
    }
    
}
