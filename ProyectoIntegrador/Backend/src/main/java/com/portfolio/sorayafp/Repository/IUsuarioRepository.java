
package com.portfolio.sorayafp.Repository;


import com.portfolio.sorayafp.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Long> {
 public Optional <Usuario> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
   
    
}
