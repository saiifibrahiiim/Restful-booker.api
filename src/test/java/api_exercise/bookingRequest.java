package api_exercise;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bookingRequest {

    private SHAFT.API api ;
    private String serviceURL = "https://restful-booker.herokuapp.com";
    private String ResponseBody;
    private String firstNameInResponseBody;


    public void CreateBooking(){

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

        ResponseBody = api.getResponseBody();
        firstNameInResponseBody = api.getResponseJSONValue("booking.firstname");

    }

    @Test
    public void Booking(){
        CreateBooking();
        System.out.println("createBookingResponseBody:"+ResponseBody);
        System.out.println("firstNameInResponseBody:"+firstNameInResponseBody);
    }

    @BeforeTest

    public void beforeBooking(){
        api = new SHAFT.API(serviceURL);
    }
}
