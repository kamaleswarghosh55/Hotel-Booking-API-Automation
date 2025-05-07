package hotelbooking.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchHotelsTest {

    @Test
    public void searchHotelsByLocation() {
        given()
                .queryParam("location", "Delhi")
                .when()
                .get("/hotels")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void searchHotelsByDate() {
        given()
                .queryParam("availableFrom", "2025-06-01")
                .when()
                .get("/hotels")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void searchHotelsByInvalidLocation() {
        given()
                .queryParam("location", "InvalidCity")
                .when()
                .get("/hotels")
                .then()
                .statusCode(200)
                .body("size()", equalTo(0));
    }

    @Test
    public void searchHotelsByUnavailableDate() {
        given()
                .queryParam("availableFrom", "2030-01-01")
                .when()
                .get("/hotels")
                .then()
                .statusCode(200)
                .body("size()", equalTo(0));
    }
}