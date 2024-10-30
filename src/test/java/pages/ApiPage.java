package pages;

import helper.Endpoint;

import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import static helper.Models.*;
import static org.assertj.core.api.Assertions.*;

public class ApiPage {

    String setURL, global_user_id = null;;
    Response res;

    public void prepareURL(String url){
       switch (url){
           case "LIST_USERS_REQRESS":
           setURL = Endpoint.LIST_USERS_REQRESS;
           break;
           case "CREATE_NEW_USER":
               setURL = Endpoint.CREATE_NEW_USER;
               break;
           case "DELETE_USER":
               setURL = Endpoint.DELETE_USER;
           case "Invalid_URL":
               setURL = Endpoint.Invalid_URL;
           default:
               System.out.println("input right URL");
       }
        System.out.println("endpoint siap pakai adalah"+setURL);
    }

    public void getUsersList(){
        res = getListUsers(setURL); //"getListUsers" nya dipanggil dari models
        System.out.println(res.getBody().asString());
    }

    public void validateStatusCode(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code); //res nya dari response yg atas,

    }

    public void validateResponseBody(){
        List<Object> id= res.jsonPath().getList("data.id");
        List<Object> email= res.jsonPath().getList("data.email");
        List<Object> first_name= res.jsonPath().getList("data.first_name");
        List<Object> last_name= res.jsonPath().getList("data.last_name");
        List<Object> avatar= res.jsonPath().getList("data.avatar");

        /* System.out.println(id.get(0));
        System.out.println(email.get(0));
        System.out.println(first_name.get(0));
        System.out.println(last_name.get(0));
        System.out.println(avatar.get(0));

        System.out.println("ID List: " + id);
        System.out.println("Email List: " + email);
        System.out.println("First Name List: " + first_name);
        System.out.println("Last Name List: " + last_name);
        System.out.println("Avatar List: " + avatar);

         */

        assertThat(id.get(1)).isNotNull();
        assertThat(email.get(1)).isNotNull();
        assertThat(first_name.get(1)).isNotNull();
        assertThat(last_name.get(1)).isNotNull();
        assertThat(avatar.get(1)).isNotNull();

    }

    public void validateJsonScheme(String filename){
        File JsonFile = Utility.getJsonSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonFile));
    }




    public void hitApiCreatePostUser(){
        res = postCreateNewUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();

        String gender = jsonPathEvaluator.get("gender");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String status = jsonPathEvaluator.get("status");
        String id = jsonPathEvaluator.get("id");

        assertThat(gender).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(status).isNotNull();
        assertThat(id).isNotNull();

        System.out.println(res.getBody().asString());
    }
    
    public void hitDeleteUser (){
        res = deleteUser(setURL, global_user_id);
    }

    public void hitUpdateUser (){
        res = updateUser(setURL, global_user_id);
    }

    public void validationResponseBodyUpdateUser(){
        System.out.println(res.getBody().asString());
    }

    public void validationResponseMessageIndicatesOrAnAppropriateErrorMessage(String expectedMessage){
        String actualMessage= res.jsonPath().getString("error");
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
