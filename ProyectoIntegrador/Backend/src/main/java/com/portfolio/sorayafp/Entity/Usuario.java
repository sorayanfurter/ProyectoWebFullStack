
package com.portfolio.sorayafp.Entity;






import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;







@Entity


@Table (name="Usuario")
public class Usuario implements Serializable  {
    
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
    public Usuario(String nombre, String apellido, String titulo, String imgBanner, String fotoPerfil, String descripcion, List<Educacion> educaciones, List<Experiencia> experiencias, List<Skill> skills, List<Proyecto> proyectos) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.imgBanner= imgBanner;
        this.fotoPerfil = fotoPerfil;
        this.descripcion = descripcion;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.skills = skills;
        this.proyectos = proyectos;
    }

    public Usuario() {
    }
    
    //Getters y Setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    
    
    

   

   
  
}
