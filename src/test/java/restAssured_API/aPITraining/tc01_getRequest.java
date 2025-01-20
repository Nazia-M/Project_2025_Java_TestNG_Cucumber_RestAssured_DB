package restAssured_API.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class tc01_getRequest {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;
    static int id;

    //Get  https://reqres.in/api/users?page=2
    @Test(groups = "qa")
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

}
