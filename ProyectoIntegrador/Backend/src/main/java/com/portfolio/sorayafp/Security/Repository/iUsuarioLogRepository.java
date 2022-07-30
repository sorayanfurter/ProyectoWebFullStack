
package com.portfolio.sorayafp.Security.Repository;

import com.portfolio.sorayafp.Security.Entity.UsuarioLog;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioLogRepository extends JpaRepository<UsuarioLog, Integer>{
    Optional<UsuarioLog> findByNombreUsuarioLog (String nombreUsuarioLog);
    
    boolean existsByNombreUsuarioLog(String nombreUsuarioLog);
    boolean existsByEmail (String email);
}
