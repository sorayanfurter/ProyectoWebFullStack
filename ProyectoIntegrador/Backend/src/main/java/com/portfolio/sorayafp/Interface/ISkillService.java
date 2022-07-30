
package com.portfolio.sorayafp.Interface;

import com.portfolio.sorayafp.Entity.Skill;
import java.util.List;


public interface ISkillService {
     
    
     public List<Skill> findAll();
     
    //Guardar 
     
    public Skill saveSkill (Skill skill);
    
    //Borrar
    
    public void deleteSkill (int id);
    
   //Find by ID
    
    public Skill findByIdSkill(int id);
     
    //Update
    
    public Skill updateSkill (Skill skill, int id);
  
     
}
