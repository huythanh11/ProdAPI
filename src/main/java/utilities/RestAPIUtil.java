package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class RestAPIUtil {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(RestAPIUtil.class));
    private Response response;
    private RequestSpecification requestSpec;
    private String endPoint = null;
    private String baseURL = null;
    private Map<String, String> endPointParams = new HashMap();
    private static String OS = System.getProperty("os.name").toLowerCase();

    public RestAPIUtil() {
    }

    public synchronized Response sendRequest(String requestType) {
        String url = null;

        Response var3;
        try {
            url = this.baseURL + this.endPoint;
            LOGGER.info("Sending " + requestType + " request to " + url);
            byte var4 = -1;
            switch(requestType.hashCode()) {
                case 70454:
                    if (requestType.equals("GET")) {
                        var4 = 0;
                    }
                    break;
                case 79599:
                    if (requestType.equals("PUT")) {
                        var4 = 3;
                    }
                    break;
                case 2461856:
                    if (requestType.equals("POST")) {
                        var4 = 1;
                    }
                    break;
                case 75900968:
                    if (requestType.equals("PATCH")) {
                        var4 = 4;
                    }
                    break;
                case 2012838315:
                    if (requestType.equals("DELETE")) {
                        var4 = 2;
                    }
            }

            switch(var4) {
                case 0:
                    this.response = this.sendGetRequest(url);
                    break;
                case 1:
                    this.response = this.sendPostRequest(url);
                    break;
                case 2:
                    this.response = this.sendDeleteRequest(url);
                    break;
                case 3:
                    this.response = this.sendPutRequest(url);
                    break;
                case 4:
                    this.response = this.sendPatchRequest(url);
            }

            var3 = this.response;
        } catch (Exception var8) {
            TapExceptionType var10002 = TapExceptionType.PROCESSING_FAILED;
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place api request for [{}]", new Object[]{url});
        } finally {
            this.clearRequestSpecObject();
        }

        return var3;
    }

    public void clearRequestSpecObject() {
        this.requestSpec = null;
    }

    public RequestSpecification getRequestSpec() {
        return this.requestSpec;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setApiBaseUri(String uri) {
        this.baseURL = uri;
    }

    public void setApiEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setEndPointParamsVar(Map<String, String> params) {
        this.endPointParams = params;
    }

    public RequestSpecification setBasicAuthentication(String username, String password) {
        LOGGER.warning("Basic authentication using " + username + " and " + password);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().auth().basic(username, password);
        } else {
            this.requestSpec = this.getRequestSpec().given().auth().basic(username, password);
        }

        return this.requestSpec;
    }

    public RequestSpecification setBasicAuthentication(String token) {
        LOGGER.warning("Basic authentication using token " + token);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().auth().oauth2(token);
        } else {
            this.requestSpec = this.getRequestSpec().given().auth().oauth2(token);
        }

        return this.requestSpec;
    }

    public RequestSpecification setHeaderParams(Map<String, String> headerParams) {
        LOGGER.warning("Setting Api header params " + headerParams.toString());
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().headers(headerParams);
        } else {
            this.requestSpec = this.getRequestSpec().given().headers(headerParams);
        }

        return this.requestSpec;
    }
    public RequestSpecification setConTentJson( ){
        LOGGER.warning("Setting Api header params ");
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().accept("application/json");
        } else {
            this.requestSpec = this.getRequestSpec().given().accept("application/json");
        }

        return this.requestSpec;
    }

    public RequestSpecification setBodyParam(String bodyContent) {
        LOGGER.warning("Setting Api body param " + bodyContent);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().header("Content-Type", "application/json").body(bodyContent);
        } else {
            this.requestSpec = this.getRequestSpec().given().body(bodyContent);
        }

        return this.requestSpec;
    }

    public RequestSpecification setBodyParam(Map<String, String> bodyContent) {
        LOGGER.warning("Setting Api body param " + bodyContent);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().formParams(bodyContent);
        } else {
            this.requestSpec = this.getRequestSpec().given().formParams(bodyContent);
        }

        return this.requestSpec;
    }

    public RequestSpecification setBodyParam(String key, String value) {
        LOGGER.warning("Setting Api body param " + value);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().formParams(key, value, new Object[0]);
        } else {
            this.requestSpec = this.getRequestSpec().given().formParams(key, value, new Object[0]);
        }

        return this.requestSpec;
    }

    public Response sendPostRequest(String url) {
        try {
            return this.getRequestSpec() == null ? (Response)RestAssured.given().when().post(url, new Object[0]) : (Response)this.getRequestSpec().when().post(url, new Object[0]);
        } catch (Exception var3) {
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place Post request for [{}]", new Object[]{url});
        }
    }

    public Response sendPostRequest(String url, Map<String, String> data) {
        try {
            return this.getRequestSpec() == null ? (Response)RestAssured.given().when().post(url, new Object[0]) : (Response)this.getRequestSpec().when().post(url, new Object[0]);
        } catch (Exception var4) {
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place Post request for [{}]", new Object[]{url});
        }
    }

    public Response sendGetRequest(String url) {
        try {
            return this.getRequestSpec() == null ? (Response)RestAssured.given().when().params(this.endPointParams).get(url, new Object[0]) : (Response)this.getRequestSpec().given().params(this.endPointParams).when().get(url, new Object[0]);
        } catch (Exception var3) {
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place Get request for [{}]", new Object[]{url});
        }
    }

    public Response sendDeleteRequest(String url) {
        try {
            return this.getRequestSpec() == null ? (Response)RestAssured.given().when().delete(url, new Object[0]) : (Response)this.getRequestSpec().when().delete(url, new Object[0]);
        } catch (Exception var3) {
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place delete request for [{}]", new Object[]{url});
        }
    }

    public Response sendPutRequest(String url) {
        try {
            return this.getRequestSpec() == null ? (Response)RestAssured.given().when().put(url, new Object[0]) : (Response)this.getRequestSpec().when().put(url, new Object[0]);
        } catch (Exception var3) {
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Not able to place put request for [{}]", new Object[]{url});
        }
    }

    public Response sendPatchRequest(String url) {
        return this.getRequestSpec() == null ? (Response)RestAssured.given().when().patch(url, new Object[0]) : (Response)this.getRequestSpec().when().patch(url, new Object[0]);
    }

    public Integer getStatusCode() {
        return this.getResponse().getStatusCode();
    }

    public String getResponseAsString() {
        return this.getResponse().asString();
    }

    public String getValueFromResponse(String jsonKey) {
        return ((ArrayList)this.getObjectFromResponse(jsonKey)).get(0).toString();
    }

    public Object getObjectFromResponse(String jsonKey) {
        return this.getObjectFromResponse(this.getResponse(), jsonKey);
    }

    public Object getObjectFromResponse(Response response, String jsonKey) {
        if (response == null) {
            return null;
        } else {
            Object value = response.jsonPath().get(jsonKey);
            LOGGER.warning("Response value for jsonKey " + jsonKey + " is " + value);
            return value;
        }
    }

    public <T> T getResponseIntoObject(Response response, String jsonKey, Class<T> clazz) {
        return response == null ? null : response.jsonPath().getObject(jsonKey, clazz);
    }

//    public void restProxySetter() {
//        if ("http://webproxy.pru.intranet.asia" != null && this.configvariable.isProxyRequired()) {
//            RestAssured.proxy(ProxySpecification.host("http://webproxy.pru.intranet.asia"));
//            RestAssured.proxy(ProxySpecification.port(Integer.parseInt("8080")));
//        }
//
//    }

    public RequestSpecification setMultiPartFormData(String key, String filePath, String fileType) {
        LOGGER.warning("Setting Api body Multipart form param " + filePath);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().multiPart(key, new File(filePath), fileType);
        } else {
            this.requestSpec = this.getRequestSpec().given().multiPart(key, new File(filePath), fileType);
        }

        return this.requestSpec;
    }

    public RequestSpecification setMultiPartFormData(String key, String filePath) {
        LOGGER.warning("Setting Api body Multipart form param " + filePath);
        if (this.getRequestSpec() == null) {
            this.requestSpec = RestAssured.given().multiPart(key, new File(filePath));
        } else {
            this.requestSpec = this.getRequestSpec().given().multiPart(key, new File(filePath));
        }

        return this.requestSpec;
    }
}
