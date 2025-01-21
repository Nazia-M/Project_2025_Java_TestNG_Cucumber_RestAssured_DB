package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;


public class HTTPRequests {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    static int id;

    //Get  https://reqres.in/api/users?page=2
    @Test
    void getMethod_LIST_USERS(){

        System.out.println("-------------- getMethod_LIST_USERS ----------------------");
        //Given
        reqSpec = RestAssured.given();

        //When
        Response response = reqSpec.when().get("https://reqres.in/api/users?page=2");
        System.out.println("---------------Response Pretty Print Start ----------------------");
        response.prettyPrint();
        System.out.println("---------------Response Pretty Print End----------------------");

        //Then
        vr = response.then();

        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());

        //Get Response data and vadiate --- Using jsonPath to get response field "page" and valdiate to 2
        int page = response.jsonPath().getInt("page");
        System.out.println("-------page is : "+page);

    }


    //Post  https://reqres.in/api/users
    //   Sending JSON data - For now using HashMap. We don't use hashmap coz if we use it we will have to hardcode the data
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }
    @Test(priority = 1)
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

    //Both Update and Delete need ID so we need to capture ID from Post request/ First create id Global variables

    //Update  https://reqres.in/api/users/{id}
    //    {
    //        "name" : "morpheus",
    //        "job"  : "leader"
    //    }
    @Test(priority = 2)
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
        String url = "https://reqres.in/api/users/"+id;
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



    //Delete  https://reqres.in/api/users/{id}  204
    @Test(priority = 3)
    void deleteMethod_DELETE(){

        System.out.println("-------------- deleteMethod_DELETE----------------------");

        reqSpec = RestAssured.given();
        System.out.println("-------------- Delete Given ---------------------");

        //When - id created in Post method global vaiable id is called
        String url = "https://reqres.in/api/users/"+id;
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
