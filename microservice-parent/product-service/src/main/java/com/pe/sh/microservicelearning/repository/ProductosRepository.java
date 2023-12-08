package com.pe.sh.microservicelearning.repository;

import com.pe.sh.microservicelearning.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shmen
*/
@Repository
public interface ProductosRepository extends MongoRepository<Productos, String>{
    
}
