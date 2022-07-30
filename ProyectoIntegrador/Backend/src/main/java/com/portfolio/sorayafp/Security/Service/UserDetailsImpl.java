
package com.portfolio.sorayafp.Security.Service;

import com.portfolio.sorayafp.Security.Entity.UsuarioLog;
import com.portfolio.sorayafp.Security.Entity.UsuarioLogPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired UsuarioLogService usuarioLogService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuarioLog) throws UsernameNotFoundException {
        UsuarioLog usuarioLog = usuarioLogService.getByNombreUsuarioLog(nombreUsuarioLog).get();
        return UsuarioLogPrincipal.build (usuarioLog);
    }
    
}
