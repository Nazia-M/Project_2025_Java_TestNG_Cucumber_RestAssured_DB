package restAssured_API.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class tc02_postRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    static int id;

    //Post  https://reqres.in/api/users
    //   Sending JSON data - For now using HashMap. We don't use hashmap coz if we use it we will have to hardcode the data
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }
    @Test(groups = "qa")
    void postMethod_CREATE(){

        System.out.println("-------------- postMethod_CREATE ----------------------");
        //Post Request Body in HashMap. But we never use HashMap in Automation
        System.out.println("-------------- Post Request Body in HashMap----------------------");
        HashMap data = new HashMap();
        data.put("name" , "morpheus");
        data.put("job" , "trainer");

        //Given  contentType can be ContentType.JSON or application/json
        reqSpec = RestAssured.given().contentType("application/json").body(data);
        System.out.println("-------------- Post Given ---------------------");

        //When
        Response response = reqSpec.when().post("https://reqres.in/api/users");
        System.out.println("-------------- Post When ---------------------");

        //Then
        vr = response.then();
        System.out.println("-------------- Post Then ---------------------");

        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());
        int status = 201;
        Assert.assertEquals(response.statusCode(), status);

        //Get Response data--- Using jsonPath to get response id and pass to udpate and delete methods
        String name = response.jsonPath().getString("name");
        System.out.println("-------name is : "+name);
        String job = response.jsonPath().getString("job");
        System.out.println("-------job is : "+job);
        id = response.jsonPath().getInt("id");
        System.out.println("-------id is : "+id);
        String createdAt = response.jsonPath().getString("createdAt");
        System.out.println("-------createdAt is : "+createdAt);
    }


    //We can send Request Body for Post,Put,Delete methods in 4 ways - HashMap, org.json, POJO, external json file


}
