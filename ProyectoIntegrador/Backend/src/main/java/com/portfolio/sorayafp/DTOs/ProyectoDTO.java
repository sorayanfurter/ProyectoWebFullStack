
package com.portfolio.sorayafp.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor


public class ProyectoDTO {
    
    private int id;
    private String nombreProyecto ;
    private String lugarProyecto;
    private String fechaProyecto;
    private String imgProyecto;
    private String descripcionProyecto;
    
    //Constructores

    public ProyectoDTO(String nombreProyecto, String lugarProyecto, String fechaProyecto, String imgProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.lugarProyecto = lugarProyecto;
        this.fechaProyecto = fechaProyecto;
        this.imgProyecto = imgProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }
    
    
   
}


