import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PrintUserEmailTest {

    @Test
    public void PrintUserEmail()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";

        Response response = RestAssured.given().param("id","4").get();
        System.out.println(response.jsonPath().getString("email"));


    }
}
