package com.portfolio.sorayafp.Entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "Educacion")
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEdu;
    private String nombreEdu;
    private String lugarEdu;
    private String fechaEdu;
    private String descripcionEdu;

    /* @JsonBackReference
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="usuario_idUsuario")
   private Usuario usuario;*/

    public Educacion(String nombreEdu, String lugarEdu, String fechaEdu, String descripcionEdu) {

        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        /* this.usuario = usuario;*/
    }

    public Educacion() {
    }

    public int getIdEdu() {
        return idEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public String getLugarEdu() {
        return lugarEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setIdEdu(int idEdu) {
        this.idEdu = idEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public void setLugarEdu(String lugarEdu) {
        this.lugarEdu = lugarEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

}
