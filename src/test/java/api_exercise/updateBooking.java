package api_exercise;

import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class updateBooking extends allMethods {
   /* private SHAFT.API api;
    private String Token;
    private String id ;

   /* public void login(){
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


    @BeforeTest
    public void Btest1 () {
        // Initialize the API object
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
        login();
        CreateBooking();

    }

    public String api_exercise.updateBooking()
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



    }*/

    @BeforeTest
    public void beforeTest(){
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
    }

    @Test
    public void testUpdateBooking() {
        login();
        CreateBooking();
        updateBooking();
        String firstName = updateBooking();
        System.out.println("First Name: " + firstName);
        Assert.assertEquals(firstName, "Sayed", "First name should match the updated value.");
    }
}
