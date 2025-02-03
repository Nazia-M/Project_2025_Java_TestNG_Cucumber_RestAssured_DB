package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class tc10_PathParam_Queryparam {


    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;

    @Test(groups = "qa")
    void testPathParam_Queryparam(){

//        Url : https://reqres.in/api/users?page=2&id=5
//        Path Param / endpoint : From above url its users
//        Query Param 1 : page=2
//        Query Param 2 : id=5

        //Given
        System.out.println("------------------ Given ---------------------");
        reqSpec = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/{mypath}")       // Path Param is created below with key mypath and value users. In BasePath call pathParam using {}
                .pathParam("mypath", "users")
                .queryParam("page", 2)
                .queryParam("id", 8).log().all();
        System.out.println("------------------ Path & Query parameter Added---------------------");

        //When
        System.out.println("------------------ When ---------------------");
        Response response = reqSpec.when().get();

        //Then Validate - Status code
        System.out.println("------------------ Then ---------------------");
        response.then().log().all();
        System.out.println("----------------Response StatusCode : "+response.statusCode());

    }
}
