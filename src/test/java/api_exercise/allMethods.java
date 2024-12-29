package api_exercise;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class allMethods {
    public SHAFT.API api;
    public String Token;
    public String id ;


    public void login(){
        api.post("/auth")
                .setContentType(ContentType.JSON)
                .setRequestBody("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .setTargetStatusCode(200)
                .perform();
        Token = api.getResponseJSONValue("token");


    }

    public void CreateBooking() {

        String CraeteBookingBody = "{\n" +
                "    \"firstname\" : \"saif\",\n" +
                "    \"lastname\" : \"sofa\",\n" +
                "    \"totalprice\" : 700,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2026-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        api.post("/booking")
                .setContentType(ContentType.JSON)
                .setRequestBody(CraeteBookingBody)
                .setTargetStatusCode(200)
                .perform();

        id = api.getResponseJSONValue("$.bookingid");
    }

    public String updateBooking()
    {

        // Perform the PUT request
        api.put("/booking/" + id)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .addCookie("token", Token) // Verify the token
                .setRequestBody("{\n" +
                        "    \"firstname\" : \"Sayed\",\n" +
                        "    \"lastname\" : \"hamdy\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .setTargetStatusCode(200) // Expect HTTP 200
                .perform();

        // Return the "firstname" field from the response JSON
        return api.getResponseJSONValue("$.firstname");
    }

    public String partialUpdate(){
        api.patch("/booking/"+id)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .addCookie("token",Token)
                .setRequestBody("{\n" +
                        "    \"firstname\" : \"ezzat\",\n" +
                        "    \"lastname\" : \"sobhy\"\n" +
                        "}")
                .setTargetStatusCode(200)
                .perform();
        return
                api.getResponseJSONValue("$.firstname");
    }

    public String DeleteBooking(){
        api.delete("/booking/"+id)
                .setContentType(ContentType.JSON)
                .addCookie("token",Token)
                .setTargetStatusCode(201)
                .perform();
        return api.getResponseBody();
    }

    public void navigateToBaseURL(){
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
    }

}
