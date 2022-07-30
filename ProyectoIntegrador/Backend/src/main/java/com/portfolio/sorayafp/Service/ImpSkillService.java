
package com.portfolio.sorayafp.Service;



import com.portfolio.sorayafp.Entity.Skill;
import com.portfolio.sorayafp.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

    public class ImpSkillService {
    
    @Autowired ISkillRepository iskillRepository;
    
     public List<Skill> list() {
        return iskillRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id) {
        return iskillRepository.findById(id);
    }

    public Optional<Skill> getByNombre(String nombreSkill) {
        return iskillRepository.findByNombreSkill(nombreSkill);
    }

    public Skill saveSkill(Skill skill) {
        return iskillRepository.save(skill);
    }
    
    
    public void deleteSkill(int id) {
        iskillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iskillRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreSkill) {
        return iskillRepository.existsByNombreSkill(nombreSkill);
    } 

   
   
}

