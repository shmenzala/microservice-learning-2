package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String>{
    
}
