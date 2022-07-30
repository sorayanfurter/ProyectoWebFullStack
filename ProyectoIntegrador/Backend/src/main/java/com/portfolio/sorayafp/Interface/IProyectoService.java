
package com.portfolio.sorayafp.Interface;


import com.portfolio.sorayafp.Entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    //Traer lista 
    
    public List<Proyecto> findAll();
    
    //Guardar  
    
    public Proyecto saveProyecto (Proyecto proyecto);
    
    //Eliminar Proyecto por ID
    
    public void deleteProyecto  (int id);
    
    //Buscar Usuario por ID
    
    public Proyecto  findByIdProyecto (int id);
    
    //Update
    
    public Proyecto updateProyecto (Proyecto proyecto, int idProyecto);
    
}
