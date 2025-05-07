package hotelbooking.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBookingsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void verifyBookingDetails() {
        given()
                .when()
                .get("/bookings/b5c5")
                .then()
                .statusCode(200)
                .body("id", equalTo("b5c5"))
                .body("hotelId", equalTo(1))
                .body("userId", equalTo(101));
    }
}