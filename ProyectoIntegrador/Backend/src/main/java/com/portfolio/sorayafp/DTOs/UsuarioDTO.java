
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Educacion;
import com.portfolio.sorayafp.Entity.Experiencia;
import com.portfolio.sorayafp.Entity.Proyecto;
import com.portfolio.sorayafp.Entity.Skill;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UsuarioDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String titulo;
    private String imgBanner;
    private String fotoPerfil;
    private String descripcion;
    
     @OneToMany(fetch= FetchType.LAZY,  mappedBy = "idEdu")
    private List<Educacion> educaciones;
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> experiencias;
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "idSkill")
    private List <Skill> skills;
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "idProyecto")
    private List <Proyecto> proyectos;
    
    
    
    //Constructores

    public UsuarioDTO(Long idUsuario, String nombre, String apellido, String titulo, String imgBanner, String fotoPerfil, String descripcion, List<Educacion> educaciones, List<Experiencia> experiencias, List<Skill> skills, List<Proyecto> proyectos) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.imgBanner = imgBanner;
        this.fotoPerfil = fotoPerfil;
        this.descripcion = descripcion;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.skills = skills;
        this.proyectos = proyectos;
    }

    public UsuarioDTO() {
    }

    
    
}
