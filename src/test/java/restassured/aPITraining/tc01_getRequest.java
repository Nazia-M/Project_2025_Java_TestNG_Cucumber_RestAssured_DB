package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tc01_getRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    //Get  https://reqres.in/api/users?page=2
    @Test(groups = "qa")
    void getMethod_LIST_USERS(){

        System.out.println("-------------- getMethod_LIST_USERS ----------------------");
        //Given
        System.out.println("----- Given ----------");
        reqSpec = RestAssured.given();
                    reqSpec.baseUri("https://reqres.in/api");
                    reqSpec.contentType(ContentType.JSON);

        //When
        System.out.println("----- When ----------");
        response = reqSpec.when().get("/users?page=2");
        System.out.println("---------------Response Pretty Print Start ----------------------");
        response.prettyPrint();
        System.out.println("---------------Response Pretty Print End----------------------");

        //Then
        System.out.println("----- Then ----------");
        vr = response.then().log().all();

        //Validation - Status code
        System.out.println("-------Response StatusCode : "+response.statusCode());

        //Get Response data and vadiate --- Using jsonPath to get response field "page" and valdiate to 2
        int page = response.jsonPath().getInt("page");
        System.out.println("-------page is : "+page);
        Assert.assertEquals(2, page);

        String first_name = response.jsonPath().getString("data.first_name[0]");
        System.out.println("------- first_name is : "+first_name);
        Assert.assertEquals("Michael", first_name);

        String first_name_1 = response.jsonPath().getString("data.first_name[1]");
        System.out.println("------- first_name_1 is : "+first_name_1);
        Assert.assertEquals("Lindsay", first_name_1);

    }

}
