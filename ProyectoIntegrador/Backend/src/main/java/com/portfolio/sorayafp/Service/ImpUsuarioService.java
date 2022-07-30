
package com.portfolio.sorayafp.Service;


import com.portfolio.sorayafp.Entity.Usuario;
import com.portfolio.sorayafp.Repository.IUsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpUsuarioService {
    
    @Autowired IUsuarioRepository iusuarioRepository;
    

     public List<Usuario> list() {
        return iusuarioRepository.findAll();
    }
    
    public Optional<Usuario> getOne(Long id) {
        return iusuarioRepository.findById(id);
    }

    public Optional<Usuario> getByNombre(String nombre) {
        return iusuarioRepository.findByNombre(nombre);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return iusuarioRepository.save(usuario);
    }
    
    
    public void deleteUsuario(Long id) {
        iusuarioRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iusuarioRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iusuarioRepository.existsByNombre(nombre);
    } 
    
    
    
}

