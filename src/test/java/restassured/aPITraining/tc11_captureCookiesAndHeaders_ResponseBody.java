package restassured.aPITraining;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

public class tc11_captureCookiesAndHeaders_ResponseBody {

    RequestSpecification reqSpec;
    Response response;

    @Test(groups = "qa", priority = 1)
    void captureCookiesFromResponse(){

        //Given
        System.out.println("------------------ Given ---------------------");
        reqSpec = RestAssured.given();

        //When
        System.out.println("---------------- When --------------");
        System.out.println("------------------ Call Google.com ------------------");
        Response response = reqSpec.when().get("https://www.google.com");

        //Then Get the Cookie
        System.out.println("----------------Capture Response Cookie AEC : "+response.getCookie("AEC"));
        System.out.println("----------------Capture Response Cookie NID : "+response.getCookie("NID"));

        System.out.println("----------------Capture All Response Cookies, return type is HashMap --------------");
        Map<String,String> cookies = response.getCookies();
        for(String cookie_name:cookies.keySet()){
            String cookie_value = response.getCookie(cookie_name);
            System.out.println("Cookie Name : "+cookie_name+" Cookies Value : "+cookie_value);
        }

        System.out.println("---------------- Log Print All Cookies --------------");
        response.then().log().cookies();

    }

    @Test(groups = "qa", priority = 2)
    void getHeaders(){

        //Given
        System.out.println("------------------ Given ---------------------");
        reqSpec = RestAssured.given();

        //When
        System.out.println("---------------- When --------------");
        Response response = reqSpec.when().get("https://www.google.com");

        //Then Get Header
        System.out.println("---------------- Then --------------");
        System.out.println("----------------Capture Response Header : Content-Type : "+response.getHeader("Content-Type"));
        System.out.println("----------------Capture Response Header : Content-Encoding : "+response.getHeader("Content-Encoding"));

        System.out.println("----------------Capture All Response Headers");
        Headers response_headers = response.getHeaders();
        for(Header header:response_headers){
            System.out.println("Header Name : "+header.getName()+" Header Values : "+header.getValue());
        }


        System.out.println("---------------- Log Print All Header --------------");
        response.then().log().headers();

    }

}
