package api_exercise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class partialUpdateBooking extends allMethods {


    @Test
    public void test3(){
        navigateToBaseURL();
        login();
        CreateBooking();
        String firstname =partialUpdate();
        Assert.assertTrue(firstname.contains("ezzat"),"ezzat is a good boy");
        System.out.println("EZZZZZZZZZZZZZZZAT");
    }
}


