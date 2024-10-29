package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders (){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint); // ini nantinya dipake di file ApiPage
    }

    public static Response postCreateNewUser(String endpoint){

        String name= "Maja Stevenson";
        String gender= "Female";
        String email =  generateRandomEmail();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

   // public static Response validateStatusCode(String endpoint){
   public static Response deleteUser(String endpoint, String user_id) {
       setupHeaders();
       String finalEndpoint = endpoint + "/" + user_id;
       return request.when().delete(finalEndpoint);
   }

    public static Response updateUser(String endpoint, String user_id) {
        setupHeaders();

        String name= "Nathan Stevenson";
        String gender= "male";
        String email =  generateRandomEmail();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);


        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

}
