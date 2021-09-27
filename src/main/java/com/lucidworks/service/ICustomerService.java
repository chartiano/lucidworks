package com.lucidworks.service;

import com.lucidworks.pojo.CustomerEntity;
import com.lucidworks.pojo.CustomerEntityPutRequest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.inject.Singleton;

/**
 *
 * @author Jose Maquera
 */
@Singleton
public interface ICustomerService {

    public Multi<CustomerEntity> getAll() ;
    
    public Uni<CustomerEntity> getById(Long id) ;

    public Uni<Long> create(CustomerEntity entity);

    public Uni<Boolean> update(Long id,CustomerEntityPutRequest entity);

    public Uni<Boolean> delete(Long id) ;
   
}
