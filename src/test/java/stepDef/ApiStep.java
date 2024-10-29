package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare URL for {string}")  // step pertama dr scenario 1 di api.feature
    public void prepareURLFor(String url) {
       apiPage.prepareURL(url);
    }

    @And("hit api get list users") //step ke dua
    public void hitApiGetListUsers() {
        apiPage.getUsersList();

    }

    @Then("validation status code is equals {int}") //step ke tiga
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validateStatusCode(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validateResponseBody();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validateJsonScheme(filename);
    }


    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiCreatePostUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
apiPage.hitDeleteUser();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPage.hitUpdateUser();
        
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();

    }
}
