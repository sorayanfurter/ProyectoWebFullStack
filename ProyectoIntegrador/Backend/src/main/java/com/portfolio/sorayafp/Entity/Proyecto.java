package com.portfolio.sorayafp.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Proyecto")

public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;
    private String nombreProyecto;
    private String lugarProyecto;
    private String fechaProyecto;
    private String imgProyecto;
    private String descripcionProyecto;

//Constructores
    public Proyecto(String nombreProyecto, String lugarProyecto, String fechaProyecto, String imgProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.lugarProyecto = lugarProyecto;
        this.fechaProyecto = fechaProyecto;
        this.imgProyecto = imgProyecto;
        this.descripcionProyecto = descripcionProyecto;

    }

}
