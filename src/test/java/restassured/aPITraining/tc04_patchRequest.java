package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class tc04_patchRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;


    //Both Update and Delete need ID so we need to capture ID from Post request/ First create id Global variables

    //Update  https://reqres.in/api/users/{id}
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }
    @Test(groups = "qa")
    void patchMethod_UPDATE(){

        System.out.println("-------------- PatchMethod_UPDATE----------------------");

        System.out.println("-------------- Patch Request Body Updated for the id in HashMap----------------------");
        HashMap data = new HashMap();
        data.put("name" , "John");
        data.put("job" , "COMPUTER SCIENCE");

        //Given  contentType can be ContentType.JSON or application/json
        System.out.println("-------------- Patch Given ---------------------");
        reqSpec = RestAssured.given().contentType("application/json").body(data).log().all();


        //When - id created in Post method global vaiable id is called
        System.out.println("-------------- Patch When ---------------------");
        tc02_postRequest tc02 = new tc02_postRequest();
        int id = tc02.user_id;
        String url = "https://reqres.in/api/users/"+id;
        System.out.println("---------URL : "+url);
        Response response = reqSpec.when().patch(url);


        //Then
        System.out.println("-------------- Patch Then ---------------------");
        vr = response.then().log().all();


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
