import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static java.util.Collections.emptyMap;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestMethodsTest {

    private final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        Response response = given()
                .when()
                .get(BASE_URL + "/get")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(emptyMap(), response.jsonPath().getMap("args"));
    }

    @Test
    public void testPostRawTextRequest() {
        String requestBody = "This is a raw text body";

        Response response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(requestBody, response.jsonPath().getString("data"));
    }

    @Test
    public void testPostFormDataRequest() {
        String key = "key";
        String value = "value";

        Response response = given()
                .formParam(key, value)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(value, response.jsonPath().getString("form." + key));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{key=value}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(requestBody, response.jsonPath().getString("data"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{key=newValue}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(requestBody, response.jsonPath().getString("data"));
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(emptyMap(), response.jsonPath().getMap("data"));
    }
}