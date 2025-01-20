package restAssured_API.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc04_deleteRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    tc02_postRequest postId;

    @Test(groups = "qa")
    void deleteMethod_DELETE(){

        System.out.println("-------------- deleteMethod_DELETE----------------------");

        reqSpec = RestAssured.given();
        System.out.println("-------------- Delete Given ---------------------");

        //When - id created in Post method global vaiable id is called
        String url = "https://reqres.in/api/users/"+(postId.id);
        System.out.println("---------URL : "+url);
        Response response = reqSpec.when().delete(url);
        System.out.println("-------------- Delete When ---------------------");

        //Then
        vr = response.then();
        System.out.println("-------------- Delete Then ---------------------");

        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());
        int status = 204;
        Assert.assertEquals(response.statusCode(), status);

    }
}
