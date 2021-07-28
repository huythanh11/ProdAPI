package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {
    static String BASE_URI="https://my-json-server.typicode.com/huythanh11/jsondata";
    public static RequestSpecification request;
    public RestAssuredExtension(){
//        RequestSpecBuilder builder = new RequestSpecBuilder();
//        builder.setBaseUri(BASE_URI);
////        builder.setBasePath("/posts");
//        builder.setContentType(ContentType.JSON);
////        RequestSpecification requestSpec = builder.build();
//        request = RestAssured.given().spec(builder.build());
//        System.out.println("xxxxx  :  " + request);


    }

    public static RequestSpecification getInstance() {
        if (request == null) {
            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBaseUri(BASE_URI);
            builder.setContentType(ContentType.JSON);
            request = RestAssured.given().spec(builder.build());
        }
        return request;
    }

    public static void GetOpswithPathParam(String url, Map<String, String> pathparams){
        request.pathParams(pathparams);
        try {
            request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public static ResponseOptions<Response> GetOps(String path){
//        getInstance();
        try {
            return request.get(new URI(path));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
