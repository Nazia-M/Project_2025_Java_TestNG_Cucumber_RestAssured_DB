package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc05_differentWaysToPassRequestBody_String {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    //1. Payload as String
    @Test(groups = "qa")
    void post_String(){

        String payload = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        //Given
        System.out.println("-------------- Post Given ---------------------");
        reqSpec = RestAssured.given()
                .contentType("application/json")
                .baseUri("https://api.restful-api.dev")
                .body(payload)
                .log().all();


        //When
        System.out.println("-------------- Post When ---------------------");
//        String url = "https://api.restful-api.dev/objects";
//        System.out.println("---------URL : "+url);
        Response response = reqSpec.when().post("/objects");


        //Then
        System.out.println("-------------- Post Then ---------------------");
        vr = response.then().log().all();


        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());
        int status = 200;
        Assert.assertEquals(response.statusCode(), status);

        //Get Response data--- Using jsonPath to get response id and pass to udpate and delete methods
        String id = response.jsonPath().getString("id");
        System.out.println("-------id is : "+id);

        String name = response.jsonPath().getString("name");
        System.out.println("-------name is : "+name);

        int year = response.jsonPath().getInt("data.year");
        System.out.println("-------year is : "+year);

        double price = response.jsonPath().getDouble("data.price");
        System.out.println("-------price is : "+price);

        String CPUmodel = response.jsonPath().getString("data.cpu_model");
        System.out.println("-------CPUmodel is : "+CPUmodel);

        String Harddisksize = response.jsonPath().getString("data.hard_disk_size");
        System.out.println("-------Harddisksize is : "+Harddisksize);

        String createdAt = response.jsonPath().getString("createdAt");
        System.out.println("-------createdAt is : "+createdAt);

        //Retrieve value using extract().path()
        String CPUmodel1 = response.then().extract().path("data.CPU_model");
        System.out.println("-------CPUmodel1 is : "+CPUmodel1);







    }
}
