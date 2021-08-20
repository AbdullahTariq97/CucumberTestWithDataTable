package com.sky.cucumber.glue;

import com.ibm.dtfj.image.ImageThread;
import com.sky.cucumber.ServiceLayer.LoginService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StepDefinitions {

    private String endPoint;
    private List<List<String>> users;

    @Given("the user is at the login page with endpoint {string}")
    public void the_user_is_at_the_login_page(String endPoint) {
        this.endPoint = endPoint;
    }
    @When("the user enters the following user details")
    public void the_user_enters_the_following_user_details(DataTable dataTable) {
        users = dataTable.asLists(String.class);
    }
    @Then("the application should say {string}")
    public void the_user_should_login_sucessfully(String expectedResponseBody) {

        for(int i = 0; i < users.size() ; i++){
            //Gets each user in list
            List<String> user = users.get(i);
            //Grabs each user's email
            String userEmail = user.get(2);
            TestRestTemplate testRestTemplate = new TestRestTemplate();
            String url = "http://localhost:8088";
            URI uri = UriComponentsBuilder.fromHttpUrl(url)
                    .path("/service/login")
                    .queryParam("email", userEmail)
                    .build()
                    .toUri();
            ResponseEntity<String> response = testRestTemplate.getForEntity(uri, String.class);
            System.err.println("The body is :" + response.getBody());
            assertEquals(expectedResponseBody, response.getBody());

        }
    }
}
