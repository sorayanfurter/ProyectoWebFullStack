
package com.portfolio.sorayafp.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuarioLog;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructores

    public JwtDto(String token, String nombreUsuarioLog, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuarioLog = nombreUsuarioLog;
        this.authorities = authorities;
    }
    
    //Getters y Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuarioLog() {
        return nombreUsuarioLog;
    }

    public void setNombreUsuarioLog(String nombreUsuarioLog) {
        this.nombreUsuarioLog = nombreUsuarioLog;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
}
