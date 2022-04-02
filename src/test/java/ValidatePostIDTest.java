import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidatePostIDTest {


    @Test
    public void ValidatePostID()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";

        Response response = RestAssured.given().param("userId","4").get();


        //user's posts
        String userPosts=response.jsonPath().getString("body");
        System.out.println(userPosts);


        //post IDs
        String PostIds=response.jsonPath().getString("id");
        System.out.println(PostIds);

        //assertions
        response.then().assertThat().body("id",everyItem(greaterThanOrEqualTo(1)));
        response.then().assertThat().body("id",everyItem(lessThanOrEqualTo(100)));


    }


}
