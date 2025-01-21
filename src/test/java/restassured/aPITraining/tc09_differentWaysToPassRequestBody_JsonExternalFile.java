package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class tc09_differentWaysToPassRequestBody_JsonExternalFile {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    //1. Create tc08_Body.json file
    //2. Add required Classes
    @Test(groups = "qa")
    void post_JsonExternalFile() throws FileNotFoundException {

        File file = new File(".\\tc08_Body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);

        //Given
        reqSpec = RestAssured.given().contentType("application/json").body(data.toString()).log().all();
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

        double price = response.jsonPath().getDouble("data.price");
        System.out.println("-------price is : "+price);

        String CPUmodel = response.jsonPath().getString("data.cpu_model");
        System.out.println("-------CPUmodel is : "+CPUmodel);

        String Harddisksize = response.jsonPath().getString("data.hard_disk_size");
        System.out.println("-------Harddisksize is : "+Harddisksize);


        String createdAt = response.jsonPath().getString("createdAt");
        System.out.println("-------createdAt is : "+createdAt);








    }
}
