package restassured.asserts;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions {

    //Assertions which can be reused

    public void verifyResponseBody(String actual, String expected, String description){

        assertThat(actual).isNotNull().isNotBlank();

        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCode(Response response, Integer expected){
        assertEquals(response.getStatusCode(), expected);
    }



}
