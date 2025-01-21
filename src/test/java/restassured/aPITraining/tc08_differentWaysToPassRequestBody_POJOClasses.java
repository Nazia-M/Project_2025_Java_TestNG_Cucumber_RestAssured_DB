package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc08_differentWaysToPassRequestBody_POJOClasses {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    // https://restful-api.dev
    //1. Identify each keys data type
    //2. Create POJO Classes based on Request Body. Declare all variables as private. Parent Class create object of sub
    //3. Add Getter & Setters to both the classes
    //4. Call POJO class in API test case and add it to the body
    @Test(groups = "qa")
    void post_POJOClasses(){

        tc08_POJOClass_1 obj = new tc08_POJOClass_1();
        obj.setName("Jim");

        tc08_POJOClass_2 data = new tc08_POJOClass_2();
        data.setYear("1991");
        data.setPrice("20543543535353");
        data.setCPU_model("Universe Got 22");
        data.setHard_disk_size("1 TB");

        obj.setData(data);


        //Given
        reqSpec = RestAssured.given().contentType("application/json").body(obj).log().all();
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
