
package com.portfolio.sorayafp.Service;



import com.portfolio.sorayafp.Entity.Proyecto;
import com.portfolio.sorayafp.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    
    @Autowired IProyectoRepository iproyectoRepository;
   
    
     public List<Proyecto> list() {
        return iproyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id) {
        return iproyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombreProyecto) {
        return iproyectoRepository.findByNombreProyecto(nombreProyecto);
    }

    public Proyecto saveProyecto(Proyecto proyecto) {
        return iproyectoRepository.save(proyecto);
    }
    
    
    public void deleteProyecto(int id) {
        iproyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iproyectoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreProyecto) {
        return iproyectoRepository.existsByNombreProyecto(nombreProyecto);
    } 

    
}
