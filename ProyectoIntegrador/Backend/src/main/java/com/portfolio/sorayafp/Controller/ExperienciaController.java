package com.portfolio.sorayafp.Controller;

import com.portfolio.sorayafp.DTOs.ExperienciaDTO;
import com.portfolio.sorayafp.Entity.Experiencia;
import com.portfolio.sorayafp.Security.Controller.Mensaje;
import com.portfolio.sorayafp.Service.ImpExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://frontendsorayaf.web.app/")
public class ExperienciaController {

    @Autowired
    ImpExperienciaService impExpService;

    @GetMapping("/listar")

    public ResponseEntity<List<Experiencia>> findAll() {
        List<Experiencia> list = impExpService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")

    public ResponseEntity<?> addExperiencia(@RequestBody ExperienciaDTO experienciadto) {
        if (experienciadto.getNombreExp()==null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impExpService.existsByNombre(experienciadto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(experienciadto.getNombreExp(), experienciadto.getLugarExp(), experienciadto.getFechaExp(), experienciadto.getDescripcionExp());
        impExpService.saveExperiencia(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia creada con exito"), HttpStatus.OK);

    }

    @PutMapping("/editar/{id}")

    public ResponseEntity<?> updateExperiencia(@RequestBody ExperienciaDTO experienciadto, @PathVariable int id) {
        if (!impExpService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (experienciadto.getNombreExp() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = impExpService.getOne(id).get();
        experiencia.setNombreExp(experienciadto.getNombreExp());
        experiencia.setLugarExp(experienciadto.getLugarExp());
        experiencia.setFechaExp(experienciadto.getFechaExp());
        experiencia.setDescripcionExp(experienciadto.getDescripcionExp());
        impExpService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExpService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impExpService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")

    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!impExpService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = impExpService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

}
