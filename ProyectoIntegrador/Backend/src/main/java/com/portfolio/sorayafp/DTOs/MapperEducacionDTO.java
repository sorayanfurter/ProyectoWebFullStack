
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Educacion;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperEducacionDTO {
    
    public EducacionDTO convertToDto(Educacion educacion){
        ModelMapper modelMapper = new ModelMapper();
        EducacionDTO educaciondto = modelMapper.map(educacion, EducacionDTO.class);
        
        return educaciondto;
    }

public List<EducacionDTO> entityToDto(List<Educacion> educacion){
        return educacion.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
    }  

public Educacion convertToEntity(EducacionDTO educaciondto){ 
        ModelMapper modelMapper = new ModelMapper();
        Educacion educacion = modelMapper.map(educaciondto, Educacion.class);
                
        return educacion;
    }
     
     public List<Educacion> dtoToEntity(List<EducacionDTO> educaciondto){
        return educaciondto.stream().map(x -> convertToEntity(x)).collect(Collectors.toList());
     }
    
}
