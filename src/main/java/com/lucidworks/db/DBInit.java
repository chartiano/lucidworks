package com.lucidworks.db;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.pgclient.PgPool;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.jboss.logging.Logger;

@ApplicationScoped
public class DBInit {

    private final PgPool client;
    private final boolean schemaCreate;
    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    public DBInit(PgPool client, @ConfigProperty(name = "restapp.schema.create", defaultValue = "true") boolean schemaCreate) {
        this.client = client;
        this.schemaCreate = schemaCreate;
    }

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        if (schemaCreate) {
            initdb();
        }
    }

    private void initdb() {
        String createTable = "create table customer (\n" +
                    "	id SERIAL PRIMARY KEY,\n" +
                    "	first_name TEXT,\n" +
                    "	last_name TEXT,\n" +
                    "	email TEXT,\n" +
                    "	company TEXT,\n" +
                    "	status TEXT\n" +
                    ")";
        client.query("DROP TABLE IF EXISTS customer").execute()
                .flatMap(r -> client.query(createTable).execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Siobhan','Brazier','sbrazier0@cisco.com','Tagpad','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Heinrick','Genese','hgenese1@ovh.net','Podcat','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Brodie','Stancer','bstancer2@businessinsider.com','Tazz','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Temple','Kleinfeld','tkleinfeld3@over-blog.com','Reallinks','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('June','Downey','jdowney4@smugmug.com','Wordware','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Seamus','Chevin','schevin5@usda.gov','Dynabox','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Dani','Godmer','dgodmer6@about.me','Jaxspan','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Rafi','Sivyer','rsivyer7@cbsnews.com','Gevee','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Dunstan','Powner','dpowner8@ucoz.com','Devbug','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Annissa','Ricioppo','aricioppo9@stumbleupon.com','Tekfly','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Corliss','Sitlinton','csitlintona@seesaa.net','Gabcube','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Hephzibah','Inman','hinmanb@ca.gov','Lajo','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Elspeth','Valentino','evalentinoc@odnoklassniki.ru','Jayo','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Klarrisa','Bizzey','kbizzeyd@ezinearticles.com','Realbuzz','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Lorrayne','Mitford','lmitforde@usa.gov','Twitterbridge','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Ferdinand','Matuska','fmatuskaf@hexun.com','Linkbridge','ACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Natalya','Wressell','nwressellg@over-blog.com','Tagchat','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Madelene','Goldie','mgoldieh@furl.net','Skinder','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Art','Stepney','astepneyi@arstechnica.com','Linkbuzz','INACTIVE')").execute())
                .flatMap(r -> client.query("INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Erma','Goodsal','egoodsalj@macromedia.com','Feednation','INACTIVE')").execute())
                
                .await().indefinitely();
    }
}
