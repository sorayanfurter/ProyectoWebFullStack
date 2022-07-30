
package com.portfolio.sorayafp.Interface;


import com.portfolio.sorayafp.Entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //Traer lista 
    
    public List<Experiencia> findAll();
    
    //Guardar  
    
    public Experiencia saveExperiencia (Experiencia experiencia);
    
    //Eliminar por ID
    
    public void deleteExperiencia(int id);
    
    //Buscar por ID
    
    public Experiencia findById(int id);
    
    //Update
    
   public Experiencia updateExperiencia (Experiencia experiencia, int idExp);
   
}
