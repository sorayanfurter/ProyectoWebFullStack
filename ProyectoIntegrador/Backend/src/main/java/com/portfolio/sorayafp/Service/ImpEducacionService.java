package com.portfolio.sorayafp.Service;


import com.portfolio.sorayafp.Entity.Educacion;
import com.portfolio.sorayafp.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ImpEducacionService  {

    @Autowired
    IEducacionRepository ieducacionRepository;

    public List<Educacion> list() {
        return ieducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id) {
        return ieducacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombre(String nombreEdu) {
        return ieducacionRepository.findByNombreEdu(nombreEdu);
    }

    public Educacion saveEducacion(Educacion educacion) {
        return ieducacionRepository.save(educacion);
    }
    
    
    public void deleteEducacion(int id) {
        ieducacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return ieducacionRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreEdu) {
        return ieducacionRepository.existsByNombreEdu(nombreEdu);
    } 
    
  

}
