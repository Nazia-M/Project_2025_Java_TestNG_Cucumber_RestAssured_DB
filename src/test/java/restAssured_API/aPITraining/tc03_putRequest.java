package restAssured_API.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class tc03_putRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    tc02_postRequest postId;

    //Both Update and Delete need ID so we need to capture ID from Post request/ First create id Global variables

    //Update  https://reqres.in/api/users/{id}
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }
    @Test
    void putMethod_UPDATE(){

        System.out.println("-------------- PutMethod_UPDATE----------------------");

        System.out.println("-------------- Put Request Body Updated for the id in HashMap----------------------");
        HashMap data = new HashMap();
        data.put("name" , "John");
        data.put("job" , "TECHNOLOGY");

        //Given  contentType can be ContentType.JSON or application/json
        reqSpec = RestAssured.given().contentType("application/json").body(data);
        System.out.println("-------------- Put Given ---------------------");

        //When - id created in Post method global vaiable id is called
        String url = "https://reqres.in/api/users/"+(postId.id);
        System.out.println("---------URL : "+url);
        Response response = reqSpec.when().put(url);
        System.out.println("-------------- Put When ---------------------");

        //Then
        vr = response.then();
        System.out.println("-------------- Put Then ---------------------");

        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());
        int status = 200;
        Assert.assertEquals(response.statusCode(), status);

        //Get Response data--- Using jsonPath to get response id and pass to udpate and delete methods
        String name = response.jsonPath().getString("name");
        System.out.println("-------name is : "+name);
        String job = response.jsonPath().getString("job");
        System.out.println("-------job is : "+job);
        String updatedAt = response.jsonPath().getString("updatedAt");
        System.out.println("-------updatedAt is : "+updatedAt);
    }
}
