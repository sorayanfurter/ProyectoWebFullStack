
package com.portfolio.sorayafp.Security.Controller;

import com.portfolio.sorayafp.Security.Dto.JwtDto;
import com.portfolio.sorayafp.Security.Dto.LoginUsuarioLog;
import com.portfolio.sorayafp.Security.Dto.NuevoUsuarioLog;
import com.portfolio.sorayafp.Security.Entity.Rol;
import com.portfolio.sorayafp.Security.Entity.UsuarioLog;
import com.portfolio.sorayafp.Security.Enums.RolNombre;
import com.portfolio.sorayafp.Security.JWT.JwtProvider;
import com.portfolio.sorayafp.Security.Service.RolService;
import com.portfolio.sorayafp.Security.Service.UsuarioLogService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")
@CrossOrigin(origins = "https://frontendsorayaf.web.app")
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UsuarioLogService usuarioLogService;
    @Autowired RolService rolService;
    @Autowired JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioLog nuevoUsuarioLog, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos incorrectos o email inválido"), HttpStatus.BAD_REQUEST);
        if (usuarioLogService.existsByNombreUsuarioLog(nuevoUsuarioLog.getNombreUsuarioLog()))
            return new ResponseEntity(new Mensaje ("Nombre de Usuario existente"), (HttpStatus.BAD_REQUEST));
        if (usuarioLogService.existsByEmail(nuevoUsuarioLog.getEmail()))
            return new ResponseEntity(new Mensaje ("Email existente"), (HttpStatus.BAD_REQUEST));
        
        UsuarioLog usuarioLog = new UsuarioLog(nuevoUsuarioLog.getNombre(), nuevoUsuarioLog.getNombreUsuarioLog(),
        nuevoUsuarioLog.getEmail(), passwordEncoder.encode(nuevoUsuarioLog.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
       
        if(nuevoUsuarioLog.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuarioLog.setRoles(roles);
        usuarioLogService.save(usuarioLog);
        return new ResponseEntity(new Mensaje ("Usuario guardado"), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto>login(@Valid @RequestBody LoginUsuarioLog loginUsuarioLog, BindingResult bindingResult){
         if(bindingResult.hasErrors())
             return new ResponseEntity(new Mensaje ("Campos incorrectos"), HttpStatus.BAD_REQUEST);
         
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
         loginUsuarioLog.getNombreUsuarioLog(), loginUsuarioLog.getPassword()));
         
         SecurityContextHolder.getContext().setAuthentication(authentication);
         
         String jwt = jwtProvider.generateToken(authentication);
         
         UserDetails userDetails = (UserDetails) authentication.getPrincipal();
         
         JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
         
         return new ResponseEntity(jwtDto, HttpStatus.OK);
         
           
    }
    
    
}
