
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Proyecto;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
public class MapperProyectoDTO {
    
    public ProyectoDTO convertToDto(Proyecto proyecto){
        ModelMapper modelMapper = new ModelMapper();
        ProyectoDTO proyectodto = modelMapper.map(proyecto, ProyectoDTO.class);
        
        return proyectodto;
    }

public List<ProyectoDTO> entityToDto(List<Proyecto> proyecto){
        return proyecto.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
    }  

public Proyecto convertToEntity(ProyectoDTO proyectodto){ 
        ModelMapper modelMapper = new ModelMapper();
        Proyecto proyecto = modelMapper.map(proyectodto, Proyecto.class);
                
        return proyecto;
    }
     
     public List<Proyecto> dtoToEntity(List<ProyectoDTO> proyectodto){
        return proyectodto.stream().map(x -> convertToEntity(x)).collect(Collectors.toList());
     }
}
    

