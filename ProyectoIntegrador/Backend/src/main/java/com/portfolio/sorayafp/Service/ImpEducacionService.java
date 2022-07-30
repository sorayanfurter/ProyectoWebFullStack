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
    
    /*
    @Override

    public Educacion saveEducacion(EducacionDTO educaciondto) {
        Educacion newEducacion = mapperEducacionDTO.convertToEntity(educaciondto);
        newEducacion = ieducacionRepository.save(newEducacion);
        return mapperEducacionDTO.convertToDto(newEducacion);

    }

    @Override
    public void deleteEducacion(Long id) {
        ieducacionRepository.deleteById(id);
    }

    @Override
    public EducacionDTO findByIdEducacion(Long id) {
        Educacion educacion = this.ieducacionRepository.findById(id).get();

        return mapperEducacionDTO.convertToDto(educacion);
    }

    @Override
    public EducacionDTO updateEducacion(EducacionDTO educaciondto, Long idEdu) {

        return ieducacionRepository.findById(idEdu).map(educacion -> {

            educacion.setNombreEdu(educaciondto.getNombreEdu());
            educacion.setLugarEdu(educaciondto.getLugarEdu());
            educacion.setFechaEdu(educaciondto.getFechaEdu());
            educacion.setDescripcionEdu(educaciondto.getDescripcionEdu());

            return mapperEducacionDTO.convertToDto(ieducacionRepository.save(educacion));

        }).orElseGet(() -> {
            Educacion newEducacion = mapperEducacionDTO.convertToEntity(educaciondto);
            newEducacion.setIdEdu(educaciondto.getIdEdu());
            newEducacion.setNombreEdu(educaciondto.getNombreEdu());
            newEducacion.setLugarEdu(educaciondto.getLugarEdu());
            newEducacion.setFechaEdu(educaciondto.getFechaEdu());
            newEducacion.setDescripcionEdu(educaciondto.getDescripcionEdu());

            return mapperEducacionDTO.convertToDto(this.ieducacionRepository.save(newEducacion));
        });

    }*/

}
