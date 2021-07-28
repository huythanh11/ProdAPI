package cucumberhooks;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utilities.FileReader;
import utilities.RestAPIUtil;
import utilities.RestAssuredExtension;

public class CucumberHooks {

    private static ResponseOptions<Response> response;
    private RestAssuredExtension extension = new RestAssuredExtension();
    public RestAPIUtil restAPIUtil = new RestAPIUtil();
    private FileReader fileReader = new FileReader();

    @Before
    public void CreateSession(){
        System.out.println("xxxxxxxxxx TAO TAO TAO");
        restAPIUtil.setApiBaseUri(fileReader.loadDataTypeSafe());
    }
}
