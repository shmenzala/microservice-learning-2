package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Orden_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface Orden_detalleRepository extends JpaRepository<Orden_detalle, String>{
    
}
