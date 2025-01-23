package restassured.baseTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import restassured.asserts.AssertActions;
import restassured.endpoints.APIConstants;
import restassured.modules.PayloadManager;

public class BaseTest {

    //Common to all Testcases - Base URL, Content-Type

    public RequestSpecification reqSpec;
    public Response response;
    public ValidatableResponse vr;
    public JsonPath jsonPath;
    public PayloadManager payloadManager;
    public AssertActions assertActions;


    @BeforeTest
    public void setUp(){
        //Before running each test Set Base URL and Content Type-JSON

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        //We can set Base URL and Content type in 2 ways. Can use any one from below
        //1. Using Restassured OR
        reqSpec = RestAssured.given().baseUri(APIConstants.BASE_URI).contentType(ContentType.JSON);
        System.out.println("SetUp : "+reqSpec);
        //2. Using RequestSpecBuilder()
//        reqSpec = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL).addHeader("Content-Type", "application/json").build();

    }


}
