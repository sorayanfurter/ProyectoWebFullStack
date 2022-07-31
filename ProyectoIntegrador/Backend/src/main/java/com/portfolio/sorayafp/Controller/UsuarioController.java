package com.portfolio.sorayafp.Controller;

import com.portfolio.sorayafp.DTOs.UsuarioDTO;
import com.portfolio.sorayafp.Entity.Usuario;
import com.portfolio.sorayafp.Repository.IUsuarioRepository;
import com.portfolio.sorayafp.Security.Controller.Mensaje;
import com.portfolio.sorayafp.Service.ImpUsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/usuario")
@CrossOrigin(origins = "https://frontendsorayaf.web.app")

public class UsuarioController {

    @Autowired
    ImpUsuarioService impUsuarioService;
      @Autowired
    IUsuarioRepository iUsuarioRepository;

    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = impUsuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")

    public ResponseEntity<?> addUsuario(@RequestBody UsuarioDTO usuariodto) {
        if (StringUtils.isBlank(usuariodto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impUsuarioService.existsByNombre(usuariodto.getNombre())) {
            return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(usuariodto.getNombre(), usuariodto.getApellido(), usuariodto.getTitulo(), usuariodto.getImgBanner(), usuariodto.getFotoPerfil(), usuariodto.getDescripcion(), usuariodto.getEducaciones(), usuariodto.getExperiencias(), usuariodto.getSkills(), usuariodto.getProyectos());
        impUsuarioService.saveUsuario(usuario);

        return new ResponseEntity(new Mensaje("Usuario creado con exito"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!impUsuarioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impUsuarioService.deleteUsuario(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")

    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        if (!impUsuarioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Usuario usuario = impUsuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

   
    @PutMapping("/editar/{id}")

    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioDTO usuariodto, @PathVariable Long id) {
        if (!impUsuarioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (usuariodto.getNombre() == null) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = impUsuarioService.getOne(id).get();
        usuario.setNombre(usuariodto.getNombre());
        usuario.setApellido(usuariodto.getApellido());
        usuario.setTitulo(usuariodto.getTitulo());
        usuario.setImgBanner(usuariodto.getImgBanner());
        usuario.setFotoPerfil(usuariodto.getFotoPerfil());
        usuario.setDescripcion(usuariodto.getDescripcion());
        impUsuarioService.saveUsuario(usuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }
   

     
}
