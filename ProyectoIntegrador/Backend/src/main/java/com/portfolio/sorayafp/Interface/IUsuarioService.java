
package com.portfolio.sorayafp.Interface;



import com.portfolio.sorayafp.Entity.Usuario;
import java.util.List;



public interface IUsuarioService {
    
    //Traer lista Usuarios
    
    public List<Usuario> findAll();
    
    //Guardar Usuario 
    
    public Usuario saveUsuario (Usuario usuariodto);
    
    //Eliminar Usuario por ID
    
    public void deleteUsuario (Long idUsuario);
    
    //Buscar Usuario por ID
    
   public Usuario findByIdUsuario(Long idUsuario);
   
   
   public Usuario updateUsuario (Usuario usuario, Long idUsuario);
    
 
    
}


