package net.kraklups.modelutil.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datavalue.DataValue;

@NoRepositoryBean
public interface DataValueRepository extends MongoRepository<DataValue, Long>, CustomDataValueRepository {

    <S extends DataValue> S save(S entity);
    
    DataValue findOne(Long primaryKey);
                                                                                                                       
    List<DataValue> findAll();

    long count();
                                                                                                                       
    void delete(DataValue entity);
                                                                                                                       
    boolean exists(Long primaryKey);
    
}
