package com.portfolio.sorayafp.Controller;

import com.portfolio.sorayafp.DTOs.EducacionDTO;
import com.portfolio.sorayafp.Entity.Educacion;
import com.portfolio.sorayafp.Security.Controller.Mensaje;
import com.portfolio.sorayafp.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontendsorayaf.web.app")

public class EducacionController {

    @Autowired
    ImpEducacionService impEduService;

    @GetMapping("/listar")

    public ResponseEntity<List<Educacion>> findAll() {
        List<Educacion> list = impEduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")

    public ResponseEntity<?> addEducacion(@RequestBody EducacionDTO educaciondto) {
        if (educaciondto.getNombreEdu() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impEduService.existsByNombre(educaciondto.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Educacion existente"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(educaciondto.getNombreEdu(), educaciondto.getLugarEdu(), educaciondto.getFechaEdu(), educaciondto.getDescripcionEdu());
        impEduService.saveEducacion(educacion);

        return new ResponseEntity(new Mensaje("Educacion creada con exito"), HttpStatus.OK);

    }

    @PutMapping("/editar/{id}")

    public ResponseEntity<?> updateEducacion(@RequestBody EducacionDTO educaciondto, @PathVariable int id) {
        if (!impEduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (educaciondto.getNombreEdu() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = impEduService.getOne(id).get();
        educacion.setNombreEdu(educaciondto.getNombreEdu());
        educacion.setLugarEdu(educaciondto.getLugarEdu());
        educacion.setFechaEdu(educaciondto.getFechaEdu());
        educacion.setDescripcionEdu(educaciondto.getDescripcionEdu());
        impEduService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        impEduService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")

    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!impEduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = impEduService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

}
