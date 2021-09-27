/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.lucidworks.resource;

import com.lucidworks.pojo.CustomerEntity;
import com.lucidworks.pojo.CustomerEntityPutRequest;
import com.lucidworks.service.CustomerService;
import com.lucidworks.service.ICustomerService;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final Logger LOGGER = Logger.getLogger(CustomerResource.class.getName());
    
    /***
     * service interface
     */
    @Inject
    private ICustomerService service;

    @GET
    public Multi<Response> get() {      
        LOGGER.info("get:begin");
        return service.getAll()
                .onItem().transform(customer -> customer != null ? Response.ok(customer) : Response.status(Status.NOT_FOUND))
                .onItem().transform(ResponseBuilder::build);
    }

    /**
     * get entity by id
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Uni<Response> getEntityById(Long id) {
        LOGGER.info("getEntityById:begin");
        return service.getById(id)
                .onItem().transform(fruit -> fruit != null ? Response.ok(fruit) : Response.status(Status.NOT_FOUND))
                .onItem().transform(ResponseBuilder::build);
    }

    /***
     * add new customer
     * @param entity
     * @return 
     */
    @POST
    @Transactional    
    public Uni<Response> create(CustomerEntity entity) {
        LOGGER.info("create:begin");
        return service.create(entity)
                .onItem().transform(id -> URI.create("/customers/" + id))
                .onItem().transform(uri -> Response.created(uri).build());
    }

    /***
     * update customer
     * @param id
     * @param entity
     * @return 
     */
    @PUT
    @Path("{id}")
    @Transactional    
    public Uni<Response> update(Long id, CustomerEntityPutRequest entity) {
        LOGGER.info("update:begin");
        return service.update(id,entity)
                .onItem().transform(updated -> updated ? Status.OK : Status.NOT_FOUND)
                .onItem().transform(status -> Response.status(status).build());
    }

    /***
     * delete customer
     * @param id
     * @return 
     */
    @DELETE
    @Path("{id}")
    @Transactional
    public Uni<Response> delete(Long id) {
        LOGGER.info("delete:begin");
        return service.delete(id)
                .onItem().transform(deleted -> deleted ? Status.NO_CONTENT : Status.NOT_FOUND)
                .onItem().transform(status -> Response.status(status).build());
    }
}
