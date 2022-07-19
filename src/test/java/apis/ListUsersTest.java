package apis;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListUsersTest {

    @Test
    public void testListAllUsers() {
        given().when().get("https://reqres.in/api/users").
                then().statusCode(200);
    }

    @Test
    public void testUserListReturnedMatchesPerPageValue() {
        given().when().get("https://reqres.in/api/users").
                then().assertThat().body("data.size()", equalTo(6));
    }
}
