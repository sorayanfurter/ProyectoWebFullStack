
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Experiencia;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


    
@Component
public class MapperExperienciaDTO {
    
    public ExperienciaDTO convertToDto(Experiencia experiencia){
        ModelMapper modelMapper = new ModelMapper();
        ExperienciaDTO experienciadto = modelMapper.map(experiencia, ExperienciaDTO.class);
        
        return experienciadto;
    }

public List<ExperienciaDTO> entityToDto(List<Experiencia> experiencia){
        return experiencia.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
    }  

public Experiencia convertToEntity(ExperienciaDTO experienciadto){ 
        ModelMapper modelMapper = new ModelMapper();
        Experiencia experiencia = modelMapper.map(experienciadto, Experiencia.class);
                
        return experiencia;
    }
     
     public List<Experiencia> dtoToEntity(List<ExperienciaDTO> experienciadto){
        return experienciadto.stream().map(x -> convertToEntity(x)).collect(Collectors.toList());
     }
}
