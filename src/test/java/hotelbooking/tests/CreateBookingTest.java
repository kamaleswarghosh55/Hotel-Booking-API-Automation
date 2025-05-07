package hotelbooking.tests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateBookingTest {

    @Test
    public void createBookingSuccessfully() {
        RestAssured.baseURI = "http://localhost:3000";

        JSONObject payload = new JSONObject();
        payload.put("hotelId", 2);
        payload.put("customerName", "Sita");
        payload.put("checkInDate", "2025-05-10");
        payload.put("checkOutDate", "2025-05-12");

        given()
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post("/bookings")
                .then()
                .statusCode(201)
                .body("customerName", equalTo("Sita"));
    }
}