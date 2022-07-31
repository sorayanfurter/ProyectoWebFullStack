package com.portfolio.sorayafp.Controller;

import com.portfolio.sorayafp.DTOs.SkillDTO;
import com.portfolio.sorayafp.Entity.Skill;
import com.portfolio.sorayafp.Security.Controller.Mensaje;
import com.portfolio.sorayafp.Service.ImpSkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://frontendsorayaf.web.app/")
public class SkillController {

    @Autowired
    ImpSkillService impSkillService;

    @GetMapping("/listar")
    @ResponseBody

    public ResponseEntity<List<Skill>> findAll() {
        List<Skill> list = impSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")

    public ResponseEntity<?> addSkill(@RequestBody SkillDTO skilldto) {
        if (StringUtils.isBlank(skilldto.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impSkillService.existsByNombre(skilldto.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Skill existente"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(skilldto.getNombreSkill(), skilldto.getImgSkill(), skilldto.getPorcentajeSkill());
        impSkillService.saveSkill(skill);

        return new ResponseEntity(new Mensaje("Skill creada con exito"), HttpStatus.OK);

    }

    @PutMapping("/editar/{id}")

    public ResponseEntity<?> updateSkill(@RequestBody SkillDTO skilldto, @PathVariable int id) {
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (skilldto.getNombreSkill() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = impSkillService.getOne(id).get();
        skill.setNombreSkill(skilldto.getNombreSkill());
        skill.setImgSkill(skilldto.getImgSkill());
        skill.setPorcentajeSkill(skilldto.getPorcentajeSkill());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impSkillService.deleteSkill(id);
        return new ResponseEntity(new Mensaje("Skill Eliminada"), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")

    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = impSkillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

}
