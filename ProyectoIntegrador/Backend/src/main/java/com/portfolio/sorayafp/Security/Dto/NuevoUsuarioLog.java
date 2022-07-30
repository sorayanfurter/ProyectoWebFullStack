
package com.portfolio.sorayafp.Security.Dto;

import java.util.HashSet;
import java.util.Set;


public class NuevoUsuarioLog {
    private String nombre;
    private String nombreUsuarioLog;
    private String email;
    private String password;
    private Set <String> roles = new HashSet<>();
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuarioLog() {
        return nombreUsuarioLog;
    }

    public void setNombreUsuarioLog(String nombreUsuarioLog) {
        this.nombreUsuarioLog = nombreUsuarioLog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    
}
