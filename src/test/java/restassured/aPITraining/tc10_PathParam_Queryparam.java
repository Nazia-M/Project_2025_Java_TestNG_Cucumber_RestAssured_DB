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
        reqSpec = RestAssured.given()
                .pathParam("mypath", "users")
                .queryParam("page", 2)
                .queryParam("id", 5);
        System.out.println("------------------ Given with Path & Query parameter---------------------");

        //When
        System.out.println("------------------ Add Path param to url ------------------");
        Response response = reqSpec.when().get("https://reqres.in/api/{mypath}");
        System.out.println("----------------- get When path param is added to url, and query param will automatically be appended to this url---------------------");

        //Then Validate - Status code
        response.then().log().all();
        System.out.println("----------------Response StatusCode : "+response.statusCode());

    }
}
