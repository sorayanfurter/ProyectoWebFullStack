
package com.portfolio.sorayafp.DTOs;

import com.portfolio.sorayafp.Entity.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuarioDTO {
    
    public UsuarioDTO convertToDto(Usuario usuario){
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO usuariodto = modelMapper.map(usuario, UsuarioDTO.class);
        
        
        return usuariodto;
    }
    
    
     public List<UsuarioDTO> entityToDto(List<Usuario> usuario){
        return usuario.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
    }
     
     
     public Usuario convertToEntity(UsuarioDTO usuariodto){ 
        ModelMapper modelMapper = new ModelMapper(); 
        Usuario usuario = modelMapper.map(usuariodto, Usuario.class);
                
        return usuario;
    }
     
     public List<Usuario> dtoToEntity(List<UsuarioDTO> usuariodto){
        return usuariodto.stream().map(x -> convertToEntity(x)).collect(Collectors.toList());
     }

    
}