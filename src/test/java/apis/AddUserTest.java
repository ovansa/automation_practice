package apis;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddUserTest {

    @Test
    public void testAddUserStatusCode() {
        Faker user = new Faker(new Locale("nl-NL"));
        HashMap data = new HashMap();
        data.put("name", user.address().firstName());
        data.put("job", user.company().profession());

        given().contentType("application/json").body(data).
                when().post("https://reqres.in/api/users").
                then().statusCode(201);
    }

    @Test
    public void testAddUserResponseBody() {
        Faker user = new Faker(new Locale("nl-NL"));
        HashMap data = new HashMap();
        data.put("name", user.address().firstName());
        data.put("job", user.company().profession());

        given().contentType("application/json").body(data).
                when().post("https://reqres.in/api/users").
                then().assertThat().body("name", equalTo(data.get("name")));
    }
}
