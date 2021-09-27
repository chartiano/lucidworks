package com.lucidworks.repo;

import io.vertx.mutiny.pgclient.PgPool;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author Jose Maquera
 */
public abstract class BaseRepository {
    protected PgPool clientDb;
    
}
