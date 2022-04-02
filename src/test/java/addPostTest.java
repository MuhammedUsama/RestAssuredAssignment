import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class addPostTest {
    @Test
    public void addPost()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";


        Map<Object ,Object> body = new HashMap<>();
        body.put("title","new title");
        body.put("body","new body");
        body.put("userId","4");


        Response response=
                RestAssured
                        .given().header("Content-type","application/json; charset=UTF-8").body(body)
                        .when().post();


        response.print();
        response.then().assertThat().contentType(ContentType.JSON);
        String id=response.jsonPath().getString("id");
        System.out.println(id);
        Assert.assertEquals(id,"101");



    }
}
