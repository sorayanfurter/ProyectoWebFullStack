
package com.portfolio.sorayafp.Security.Service;

import com.portfolio.sorayafp.Security.Entity.UsuarioLog;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.sorayafp.Security.Repository.iUsuarioLogRepository;

@Service
@Transactional
public class UsuarioLogService {
    @Autowired iUsuarioLogRepository iusuarioLogRepository;
    
    public Optional<UsuarioLog> getByNombreUsuarioLog (String nombreUsuarioLog){
        return iusuarioLogRepository.findByNombreUsuarioLog (nombreUsuarioLog);
    }
    
    public boolean existsByNombreUsuarioLog (String nombreUsuarioLog){
        return iusuarioLogRepository.existsByNombreUsuarioLog(nombreUsuarioLog);
    }
    
    public boolean existsByEmail (String email){
        return iusuarioLogRepository.existsByEmail(email);
    }
    
    public void save (UsuarioLog usuarioLog) {
        iusuarioLogRepository.save(usuarioLog);
    }
            
} 
