
package com.lucidworks.repo;

import com.lucidworks.pojo.CustomerEntity;
import com.lucidworks.pojo.CustomerEntityPutRequest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

/**
 *
 * @author Jose Maquera
 */
@ApplicationScoped
public class CustomerRepository extends BaseRepository   {
    protected final boolean schemaCreate;
    
    private static final Logger LOGGER = Logger.getLogger(CustomerRepository.class.getName());
    
    public  CustomerRepository(PgPool client, @ConfigProperty(name = "restapp.schema.create", defaultValue = "true") boolean schemaCreate) {
        this.clientDb = client;
        this.schemaCreate = schemaCreate;
    }
    
    public Multi<CustomerEntity> findAll() {
        LOGGER.info("findAll::begin");
        return this.clientDb.query("SELECT id, first_name, last_name,email,company, status  FROM customer ORDER BY first_name ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(CustomerRepository::from);
    }

    public Uni<CustomerEntity> findById(Long id) {
        LOGGER.info("findById::begin");
        return this.clientDb.preparedQuery("SELECT id, first_name, last_name,email,company, status  FROM customer WHERE id = $1").execute(Tuple.of(id))
                .onItem().transform(RowSet::iterator)
                .onItem().transform(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
    }

    public Uni<Long> add(CustomerEntity entity) {
        LOGGER.info("add::begin");
        return this.clientDb.preparedQuery(
                "INSERT INTO customer (first_name,last_name,email,company,status) "
                        + "VALUES ($1,$2,$3,$4,$5) RETURNING id")
                .execute(Tuple.of(
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getEmail(),
                        entity.getCompany(),
                        entity.getStatus()))
                .onItem().transform(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }

    public Uni<Boolean> update(Long id,CustomerEntityPutRequest entity) {
        LOGGER.info("update::begin");
        return this.clientDb.preparedQuery(
                "UPDATE customer SET "
                        + "first_name = $1 "
                        + ",last_name = $2 "
                        + ",email = $3 "
                        + ",company = $4 "
                        + ",status = $5 "
                + "WHERE id = $6")
                .execute(Tuple.of(
                        entity.getFirstName(), 
                        entity.getLastName(),
                        entity.getEmail(),
                        entity.getCompany(),
                        entity.getStatus(),
                        id))
        .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    public Uni<Boolean> delete(Long id) {
        LOGGER.info("delete::begin");
        return this.clientDb.preparedQuery("DELETE FROM customer WHERE id = $1").execute(Tuple.of(id))
                .onItem().transform(pgRowSet -> pgRowSet.rowCount() == 1);
    }

    private static CustomerEntity from(Row row) {
        LOGGER.info("delete::begin::row=");
        LOGGER.info(row);
        CustomerEntity entity = new CustomerEntity();
        entity.setId(row.getLong("id"));        
        entity.setFirstName(row.getString("first_name"));        
        entity.setLastName(row.getString("last_name"));        
        entity.setEmail(row.getString("email"));        
        entity.setCompany(row.getString("company"));        
        entity.setStatus(row.getString("status"));        
        
        
        // add additional fields
        return entity;
    }
}
