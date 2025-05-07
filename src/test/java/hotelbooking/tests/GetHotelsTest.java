package hotelbooking.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class GetHotelsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void verifyHotelsByLocation() {
        given()
                .queryParam("location", "Delhi")
                .when()
                .get("/hotels")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}