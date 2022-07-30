
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

    /*
    public List<Skill> findAll() {
        
       return iskillRepository.findAll()       
 
				        
    }
   
    @Override
    public SkillDTO saveSkill(SkillDTO skilldto) {
        Skill skill = mapperSkillDTO.convertToEntity(skilldto);
        skill = iskillRepository.save(skill);
        return mapperSkillDTO.convertToDto(skill);
     } 

    @Override
    public void deleteSkill(Long id) {
        iskillRepository.deleteById(id);
    }
    
    @Override
    public SkillDTO findByIdSkill(Long id){
          Skill skill = this.iskillRepository.findById(id).get();
        
		return mapperSkillDTO.convertToDto(skill);
    }
    
    @Override
    public SkillDTO updateSkill (SkillDTO skilldto, Long idSkill){
       
	return iskillRepository.findById(idSkill).map(skill -> {
	 skill.setNombreSkill(skilldto.getNombreSkill());
         skill.setImgSkill(skilldto.getImgSkill());
         skill.setPorcentajeSkill(skilldto.getPorcentajeSkill());
         
                
	return mapperSkillDTO.convertToDto(iskillRepository.save(skill));
         
       }).orElseGet(() -> {
           Skill newSkill = mapperSkillDTO.convertToEntity(skilldto);
           newSkill.setIdSkill(idSkill);
           return mapperSkillDTO.convertToDto(this.iskillRepository.save(newSkill));
       });
    } */
    
   
}

