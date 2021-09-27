package com.lucidworks.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class CustomerResourceTest {

    @Test
    public void testListAllCustomers() {
        //List all, should have all 4 fruits the database has initially:
        given()
                .when().get("/customers")
                .then()
                .statusCode(200)
                .body(
                        containsString("Siobhan"),
                        containsString("Heinrick"),
                        containsString("Brodie"),
                        containsString("Temple"));

        //Delete the Kiwi:
        given()
                .when().delete("/customers/1")
                .then()
                .statusCode(204);

        //List all, Kiwi should be missing now:
        given()
                .when().get("/customers")
                .then()
                .statusCode(200)
                .body(
                        not(containsString("Siobhan")),
                        containsString("Heinrick"),
                        containsString("Brodie"),
                        containsString("Temple"));
                
    }

}
