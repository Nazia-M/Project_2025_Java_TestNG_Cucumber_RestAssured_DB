package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class tc06_differentWaysToPassRequestBody_HashMap {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    @Test(groups = "qa")
    void post_HashMap(){

        LinkedHashMap map = new LinkedHashMap();
        map.put("name","Scott");

        LinkedHashMap data = new LinkedHashMap();
        data.put("year", 4324);
        data.put("price", 43242);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");
        map.put("data", data);

        //Given
        reqSpec = RestAssured.given().contentType("application/json").body(map).log().all();
        System.out.println("-------------- Post Given ---------------------");

        //When
        String url = "https://api.restful-api.dev/objects";
        System.out.println("---------URL : "+url);
        Response response = reqSpec.when().post(url);
        System.out.println("-------------- Post When ---------------------");

        //Then
        vr = response.then().log().all();
        System.out.println("-------------- Post Then ---------------------");

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

        int price = response.jsonPath().getInt("data.price");
        System.out.println("-------price is : "+price);

        String CPUmodel = response.jsonPath().getString("data.cpu_model");
        System.out.println("-------CPUmodel is : "+CPUmodel);

        String Harddisksize = response.jsonPath().getString("data.hard_disk_size");
        System.out.println("-------Harddisksize is : "+Harddisksize);


        String createdAt = response.jsonPath().getString("createdAt");
        System.out.println("-------createdAt is : "+createdAt);








    }
}
