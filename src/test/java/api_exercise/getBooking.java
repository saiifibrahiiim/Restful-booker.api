package api_exercise;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getBooking {

    public SHAFT.API api;
    public String serviceURL = "https://restful-booker.herokuapp.com";

    @BeforeClass
    public void beforeClass() {
        // Initialize the API object
        api = new SHAFT.API(serviceURL);
    }

    public String getBooking(int id) {
        try {
            // Perform GET request and set Accept header
            api.get("/booking/" + id)
                  //  .addHeader("Accept", "application/json")
                    .setTargetStatusCode(200)
                    .perform();

            // Extract and return the firstname
            return api.getResponseJSONValue("$.firstname");
        } catch (Exception e) {
            System.err.println("Error occurred while fetching booking: " + e.getMessage());
            return "Error: Booking not found or invalid response.";
        }
    }

    @Test
    public void testGetBooking() {
        String firstName = getBooking(637); // Use a known valid booking ID
        System.out.println("First Name: " + firstName);

        // Validate the response
        org.testng.Assert.assertNotNull(firstName, "The first name should not be null.");
        org.testng.Assert.assertFalse(firstName.isEmpty(), "The first name should not be empty.");
    }
}
