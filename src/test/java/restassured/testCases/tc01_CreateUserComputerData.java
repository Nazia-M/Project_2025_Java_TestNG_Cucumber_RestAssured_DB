package restassured.testCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import restassured.baseTest.BaseTest;
import restassured.endpoints.APIConstants;
import restassured.pojos.BookingResponse;
import restassured.pojos.tc12_Response_POJO_Deserialization_1;

public class tc01_CreateUserComputerData extends BaseTest {

    @Test(groups = "qa")
    public void post_create_booking(){

        System.out.println("Set Base Path");
        reqSpec = reqSpec.basePath(APIConstants.CREATE_DATA).log().all();

        System.out.println("Give Payload");
            response = RestAssured.given(reqSpec).when().body(payloadManager.createUserComputerData_Serialziation()).post();

        System.out.println("Verify Response");
            vr = response.then().log().all().statusCode(200);

        System.out.println("Desrialziation");
            tc12_Response_POJO_Deserialization_1 apiResponse = payloadManager.createUserComputerData_DeSerialziation(response.asString());

        System.out.println("Verify Response Body");
            assertActions.verifyResponseBody(apiResponse.getName(), "Nazia M", "Verify Firstname");
    }

}
