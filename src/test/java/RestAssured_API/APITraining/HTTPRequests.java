package RestAssured_API.APITraining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    String token;
    int bookingId;

    //Get  https://reqres.in/api/users?page=2
    @Test
    void getMethod(){

        //Given
        reqSpec = RestAssured.given();

        //When
        Response response = reqSpec.when().get("https://reqres.in/api/users?page=2");
        System.out.println("---------------Response Pretty Print Start ----------------------");
        response.prettyPrint();
        System.out.println("---------------Response Pretty Print End----------------------");

        //Validation - Status code
        vr = response.then().log().all();
        System.out.println("Response StatucODE");
        Assert.assertEquals(response.statusCode(), 200, "Check for Status Code 200");

        //Validate Response data
        vr.body("page", equalTo(2)).log().all();

    }


    //Post  https://reqres.in/api/users
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }



    //Update  https://reqres.in/api/users/2
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }




    //Delete  https://reqres.in/api/users/{userid}  204
}
