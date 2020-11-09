
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserTest {

    /**
     * example of validation of an API with rest assured
     */
    @Test
    public void testRestAssured() {
        RestAssured.given()
            .when()
            .queryParam("page", 2)
            .get("https://reqres.in/api/users")
            .then()
            .assertThat()
            .statusCode(200)
            .body("page", equalTo(2), "ad.company", equalTo("StatusCode Weekly"));
    }

    /**
     * example of JSON schema validation with rest assured
     */
    @Test
    public void testJsonSchema() {
        RestAssured.given()
            .when()
            .queryParam("page", 2)
            .get("https://reqres.in/api/users")
            .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("userSchema.json"));
    }
}
