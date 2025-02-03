package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class tc15_Authentication {

    RequestSpecification reqSpec;
    ValidatableResponse vr;
    Response response;


    @Test(priority = 0)
    public void basicAuthentication_NegativeTestCase(){

        System.out.println("---------------- No Username and Password API Response Negative Test case-----------------");
        System.out.println("---------------- Given -----------------");
        reqSpec = RestAssured.given().log().all();


        //When
        System.out.println("----------------When -----------------");
        Response response = reqSpec.when().get("https://postman-echo.com/basic-auth");


        //Then
        System.out.println("----------------Then -----------------");
        vr = response.then().log().all();

        System.out.println("---------------- API Response Body -----------------");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

    @Test(priority = 1)
    public void basicAuthentication(){

        System.out.println("---------------- BASIC AUTHENTICATION -----------------");
        System.out.println("---------------- Given -----------------");
        reqSpec = RestAssured.given().auth().basic("postman", "password").log().all();


        //When
        System.out.println("----------------When -----------------");
        Response response = reqSpec.when().get("https://postman-echo.com/basic-auth");


        //Then
        System.out.println("----------------Then -----------------");
        vr = response.then().log().all();

        System.out.println("---------------- API Response Body -----------------");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);


    }

    @Test(priority = 2)
    public void digestAuthentication(){

        System.out.println("---------------- DIGEST AUTHENTICATION -----------------");
        System.out.println("---------------- Given -----------------");
        reqSpec = RestAssured.given().auth().digest("postman", "password").log().all();


        //When
        System.out.println("----------------When -----------------");
        Response response = reqSpec.when().get("https://postman-echo.com/basic-auth");


        //Then
        System.out.println("----------------Then -----------------");
        vr = response.then().log().all();

        System.out.println("---------------- API Response Body -----------------");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);


    }

    @Test(priority = 3)
    public void BearerToken(){

        System.out.println("---------------- BEARER TOKEN AUTHENTICATION -----------------");
        String userId = "toolsqa_test";

        String baseUrl = "https://demoqa.com";

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";

        String isbn = "9781449325865";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json");


        //When
        System.out.println("----------------When -----------------");
        Response response = reqSpec.when().get(baseUrl);


        //Then
        System.out.println("----------------Then -----------------");
        vr = response.then().log().all();

        System.out.println("---------------- API Response Body -----------------");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

}
