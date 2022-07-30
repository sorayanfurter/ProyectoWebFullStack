package com.portfolio.sorayafp.Controller;

import com.portfolio.sorayafp.DTOs.ProyectoDTO;
import com.portfolio.sorayafp.Entity.Proyecto;
import com.portfolio.sorayafp.Security.Controller.Mensaje;
import com.portfolio.sorayafp.Service.ImpProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

    @Autowired
    ImpProyectoService impProyectoService;

    @GetMapping("/listar")
    @ResponseBody

    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = impProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")

    public ResponseEntity<?> addProyecto(@RequestBody ProyectoDTO proyectodto) {
        if (StringUtils.isBlank(proyectodto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.existsByNombre(proyectodto.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(proyectodto.getNombreProyecto(), proyectodto.getLugarProyecto(), proyectodto.getFechaProyecto(),proyectodto.getImgProyecto(), proyectodto.getDescripcionProyecto());
        impProyectoService.saveProyecto(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto creado con exito"), HttpStatus.OK);

    }

    @PutMapping("/editar/{id}")

    public ResponseEntity<?> updateProyecto(@RequestBody ProyectoDTO proyectodto, @PathVariable int id) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (proyectodto.getNombreProyecto() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = impProyectoService.getOne(id).get();
        proyecto.setNombreProyecto(proyectodto.getNombreProyecto());
        proyecto.setLugarProyecto(proyectodto.getLugarProyecto());
        proyecto.setFechaProyecto(proyectodto.getFechaProyecto());
        proyecto.setImgProyecto(proyectodto.getImgProyecto());
        proyecto.setDescripcionProyecto(proyectodto.getDescripcionProyecto());
        impProyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")

    public ResponseEntity<?> deleteProyecto(@PathVariable("id") int idProyecto) {
        if (!impProyectoService.existsById(idProyecto)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impProyectoService.deleteProyecto(idProyecto);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")

    public ResponseEntity<Proyecto> getById(@PathVariable("id") int idProyecto) {
        if (!impProyectoService.existsById(idProyecto)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = impProyectoService.getOne(idProyecto).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    /*   @Autowired IProyectoService iproyectoService;
    
 @GetMapping("/listar") 
 @ResponseBody
 
  public List<ProyectoDTO>findAll(){
     return  iproyectoService.findAll();
    
  } 
    
 @PostMapping("/crear")
 
  public String saveProyecto(@RequestBody ProyectoDTO proyectodto){
   iproyectoService.saveProyecto(proyectodto);
   return "Proyecto creado correctamente";
     
  }
  
 @DeleteMapping ("/borrar/{id}")
      public void deleteProyecto(@PathVariable Long id){
      iproyectoService.deleteProyecto(id); 
      
    }    
      
 @GetMapping("/listar/{id}")
      public ProyectoDTO findByIdProyecto(@PathVariable Long id) {
         return iproyectoService.findByIdProyecto(id);
	} 
        
 @PutMapping ("/editar/{id}")
     public ProyectoDTO updateProyecto(@RequestBody ProyectoDTO newProyecto , @PathVariable Long id){
         return iproyectoService.updateProyecto (newProyecto, id);      
    }     
     */
}
