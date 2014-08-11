package net.kraklups.modelutil.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends 
					MongoRepository<T, ID> {
	
    <S extends T> S save(S entity);
    
    T findOne(ID primaryKey);
    
    void delete(T entity);
    
    boolean exists(ID primaryKey);
	
}
