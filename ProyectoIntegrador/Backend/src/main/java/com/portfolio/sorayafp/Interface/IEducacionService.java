
package com.portfolio.sorayafp.Interface;




import com.portfolio.sorayafp.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
      
    public List<Educacion> findAll();
    
    //Guardar 
    
    public Educacion saveEducacion (Educacion educacion);
    
    //Eliminar  por ID
    
    public void deleteEducacion (int id);
    
        
    //Buscar por idEdu
    public Educacion findById(int id);
   
    //Update
    
    public Educacion updateEducacion (Educacion educacion, int id);
  
  
  
   
  
            
}

