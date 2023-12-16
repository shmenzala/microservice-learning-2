package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Inventario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String>{
    
    public List<Inventario> findBySkuCodeIn(List<String> skucode);
    
}
