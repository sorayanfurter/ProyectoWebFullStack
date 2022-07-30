package com.portfolio.sorayafp.Service;

import com.portfolio.sorayafp.Entity.Experiencia;
import com.portfolio.sorayafp.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {

    @Autowired
    IExperienciaRepository iexperienciaRepository;

    public List<Experiencia> list() {
        return iexperienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return iexperienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombre(String nombreExp) {
        return iexperienciaRepository.findByNombreExp(nombreExp);
    }

    public Experiencia saveExperiencia(Experiencia experiencia) {
        return iexperienciaRepository.save(experiencia);
    }

    public void deleteExperiencia(int id) {
        iexperienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iexperienciaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreExp) {
        return iexperienciaRepository.existsByNombreExp(nombreExp);
    }

}
