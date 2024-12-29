package api_exercise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteBooking extends allMethods {
    @Test
    public void test4(){
        navigateToBaseURL();
        login();
        CreateBooking();
        partialUpdate();
       String responseBody = DeleteBooking();
       System.out.println("----------------"+responseBody);
       Assert.assertTrue(responseBody.contains("Created"));

    }

}
