package com.lucidworks.service;

import com.lucidworks.pojo.CustomerEntity;
import com.lucidworks.pojo.CustomerEntityPutRequest;
import com.lucidworks.repo.CustomerRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jboss.logging.Logger;

/**
 *
 * @author Jose Maquera
 */

@ApplicationScoped
public class CustomerService implements ICustomerService {
    @Inject
    private CustomerRepository repository;
    
    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());
    
    /**
     * 
     * @return 
     */
    public Multi<CustomerEntity> getAll() {
        LOGGER.info("getAll::begin");
        return repository.findAll();
    }

    /**
     * 
     * @param id
     * @return 
     */
    public Uni<CustomerEntity> getById(Long id) {
        LOGGER.info("getById::begin");
        return repository.findById(id);
    }

    /**
     * 
     * @param entity
     * @return 
     */
    public Uni<Long> create(CustomerEntity entity) {
        LOGGER.info("create::begin");
        return repository.add(entity);
    }

    /**
     * 
     * @param id
     * @param entity
     * @return 
     */
    public Uni<Boolean> update(Long id,CustomerEntityPutRequest entity) {
        LOGGER.info("update::begin");        
        return repository.update(id, entity);
        
    }

    /**
     * 
     * @param id
     * @return 
     */
    public Uni<Boolean> delete(Long id) {
        LOGGER.info("delete::begin");
        return repository.delete(id);
    }

   
}
