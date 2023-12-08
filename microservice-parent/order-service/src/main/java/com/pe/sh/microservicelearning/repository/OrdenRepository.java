package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface OrdenRepository extends JpaRepository<Orden, String>{
    
}
