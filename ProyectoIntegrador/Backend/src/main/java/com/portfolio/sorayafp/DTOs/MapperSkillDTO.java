
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Skill;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


    
@Component
public class MapperSkillDTO {
    
    public SkillDTO convertToDto(Skill skill){
        ModelMapper modelMapper = new ModelMapper();
        SkillDTO skilldto = modelMapper.map(skill, SkillDTO.class);
        
        return skilldto;
    }

public List<SkillDTO> entityToDto(List<Skill> skill){
        return skill.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
    }  

public Skill convertToEntity(SkillDTO skilldto){ 
        ModelMapper modelMapper = new ModelMapper();
        Skill skill = modelMapper.map(skilldto, Skill.class);
                
        return skill;
    }
     
     public List<Skill> dtoToEntity(List<SkillDTO> skilldto){
        return skilldto.stream().map(x -> convertToEntity(x)).collect(Collectors.toList());
     }
    
}
