package hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBookingTest {

    private String bookingId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";

        String requestBody = """
            {
              "hotelId": 1,
              "userId": 101,
              "checkInDate": "2025-06-05",
              "checkOutDate": "2025-06-10",
              "status": "confirmed"
            }
        """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/bookings");

        bookingId = response.jsonPath().getString("id");
    }

    @Test
    public void updateBookingStatus() {
        String updatedBody = """
            {
              "status": "cancelled"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .patch("/bookings/" + bookingId)
                .then()
                .statusCode(200)
                .body("status", equalTo("cancelled"));
    }
}