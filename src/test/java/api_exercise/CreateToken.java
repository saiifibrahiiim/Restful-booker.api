package api_exercise;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateToken {

    private SHAFT.API api; // Object for API calls
    private String Token; // Variable to store the token

    // Status Codes
    private final int success_statusCode = 200;

    // Service names
    private final String authentication_serviceName = "/auth";

    public void CreateToken() {
        String tokenBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";



        // Perform the POST request and capture the response
        api.post(authentication_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenBody)
                .setTargetStatusCode(success_statusCode)
                .perform();

        Token = api.getResponseJSONValue("token");  //msh fahm lah hena lazm tb2a token msh ay 7aga tanya

        // Store the token
       // Token = token;
    }

    @BeforeClass
    public void beforeClass() {
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
    }

    @Test
    public void test1() {
        CreateToken();
        System.out.println("token: " + Token);

        // Assert the token is not null
        Assert.assertNotNull(Token, "Authentication token should not be null.");
    }
}
