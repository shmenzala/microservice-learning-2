package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Orden;
import com.pe.sh.microservicelearning.model.Orden_detalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface Orden_detalleRepository extends JpaRepository<Orden_detalle, String>{
    
    public List<Orden_detalle> findAllByOrden(Orden codigood);
}
