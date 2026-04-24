
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {

    private RequestSpecification commonRequestSpec;
    private ResponseSpecification commonResponseSpec;

    @BeforeMethod
    public void setUp(){
        commonRequestSpec = new RequestSpecBuilder()
                .setBaseUri("https://postman-echo.com")
                .build();
        commonResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void getRequestTest(){
        given()
                .spec(commonRequestSpec)
        .when()
                .get("/get?foo1=bar1&foo2=bar2")
        .then()
                .spec(commonResponseSpec)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawTextTest(){
        String requestBody = "{\n    \"test\": \"value\"\n}";

        given()
                .spec(commonRequestSpec)
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .post("/post")
        .then()
                .spec(commonResponseSpec)
                .log().body()
                .body("data", equalTo(requestBody));
    }

    @Test
    public void postFormDataTest() {
        given()
                .spec(commonRequestSpec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .log().all()
        .when()
                .post("/post")
        .then()
                .log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRequestTest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(commonRequestSpec)
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .put("/put")
        .then()
                .spec(commonResponseSpec)
                .log().body()
                .body("data", equalTo(requestBody));
    }

    @Test
    public void patchRequestTest(){
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(commonRequestSpec)
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .patch("/patch")
        .then()
                .spec(commonResponseSpec)
                .log().body()
                .body("data", equalTo(requestBody));
    }

    @Test
    public void deleteRequestTest(){
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(commonRequestSpec)
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .log().all()
        .when()
                .delete("/delete")
        .then()
                .spec(commonResponseSpec)
                .log().body()
                .body("data", equalTo(requestBody));
    }
}
