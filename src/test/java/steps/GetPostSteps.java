package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import cucumberhooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import screens.StudentMap;
import utilities.FileReader;
import utilities.RestAPIUtil;

import static io.restassured.RestAssured.given;

public class GetPostSteps  {
//    private static ResponseOptions<Response> response;
    private static StudentMap  student = new StudentMap();
    public RestAPIUtil restAPIUtil = new RestAPIUtil();
    private FileReader fileReader = new FileReader();

    @Given("I perform GET API for {string}")
    public void iPerformGETAPIFor(String url) throws JsonProcessingException {
        restAPIUtil.setApiBaseUri(fileReader.loadDataTypeSafe());
        restAPIUtil.setApiEndPoint("/posts");
        restAPIUtil.setBodyParam(student.createStudent());
        Response response = restAPIUtil.sendRequest("GET");
        System.out.println(response.getBody().jsonPath().get("lastname").toString());
//        System.out.println(response.getBody().jsonPath().get().toString());
    }

    @And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String arg0) {
        FileReader file = new FileReader();
        String xx = file.loadPropertyFile("stg").getProperty("aa");


    }

    @Then("I should see author name as {string}")
    public void iShouldSeeAuthorNameAs(String arg0) {
    }

    @And("I run  GET for the post number {string}")
    public void iRunGETForThePostNumber(String arg0) {
    }

    @Then("I run see author name as {string}")
    public void iRunSeeAuthorNameAs(String arg0) {
    }
}
