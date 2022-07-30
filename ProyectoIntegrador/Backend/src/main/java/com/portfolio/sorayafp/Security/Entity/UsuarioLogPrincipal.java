package com.portfolio.sorayafp.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioLogPrincipal implements UserDetails {

    private String nombre;
    private String nombreUsuarioLog;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    //Constructor
    public UsuarioLogPrincipal(String nombre, String nombreUsuarioLog, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuarioLog = nombreUsuarioLog;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioLogPrincipal build(UsuarioLog usuarioLog) {
        List<GrantedAuthority> authorities = usuarioLog.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors
                .toList());
        return new UsuarioLogPrincipal(usuarioLog.getNombre(), usuarioLog.getNombreUsuarioLog(), usuarioLog.getEmail(), usuarioLog.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUsuarioLog;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
