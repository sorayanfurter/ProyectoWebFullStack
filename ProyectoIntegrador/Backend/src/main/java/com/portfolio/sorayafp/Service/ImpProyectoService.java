
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
    
  
  /*
    @Override
    public List<ProyectoDTO> findAll() {
        
       return iproyectoRepository.findAll()       
       .stream().map(x -> mapperProyectoDTO.convertToDto(x)).collect(Collectors.toList());
				        
    }
    
    @Override
              
    public ProyectoDTO saveProyecto(ProyectoDTO proyectodto) {
    Proyecto proyecto = mapperProyectoDTO.convertToEntity(proyectodto);
        proyecto = iproyectoRepository.save(proyecto);
        return mapperProyectoDTO.convertToDto(proyecto);
       
    }  
       
    @Override
    public void deleteProyecto(Long id) {
        iproyectoRepository.deleteById(id);
    }
    
    
    @Override
    public ProyectoDTO findByIdProyecto(Long id){
        Proyecto proyecto = this.iproyectoRepository.findById(id).get();
        
		return mapperProyectoDTO.convertToDto(proyecto);
    }
  
       
    @Override
    public ProyectoDTO updateProyecto (ProyectoDTO proyectodto, Long id){
       
	return iproyectoRepository.findById(id).map(proyecto -> {
	 proyecto.setNombreProyecto(proyectodto.getNombreProyecto());
         proyecto.setLugarProyecto(proyectodto.getLugarProyecto());
         proyecto.setFechaProyecto(proyectodto.getFechaProyecto());
         proyecto.setImgProyecto(proyectodto.getImgProyecto());
         proyecto.setDescripcionProyecto(proyectodto.getDescripcionProyecto());
         
         
	return mapperProyectoDTO.convertToDto(iproyectoRepository.save(proyecto));
         
       }).orElseGet(() -> {
           Proyecto newProyecto = mapperProyectoDTO.convertToEntity(proyectodto);
           newProyecto.setIdProyecto(id);
           return mapperProyectoDTO.convertToDto(this.iproyectoRepository.save(newProyecto));
       });
    }  
    */
    
}
