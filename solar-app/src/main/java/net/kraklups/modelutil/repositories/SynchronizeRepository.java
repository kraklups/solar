package net.kraklups.modelutil.repositories;

import java.util.List;

import net.kraklups.solarapp.model.datavalue.DataValue;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SynchronizeRepository extends MongoRepository<DataValue, Long>, CustomDataValueRepository<DataValue, Long> {

    <S extends DataValue> S save(S entity);
    
    DataValue findOne(Long primaryKey);
                                                                                                                       
    List<DataValue> findAll();

    long count();
                                                                                                                       
    void delete(DataValue entity);
                                                                                                                       
    boolean exists(Long primaryKey);
    
}
