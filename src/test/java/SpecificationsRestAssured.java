import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class SpecificationsRestAssured {

    private static RequestSpecification VideoGameRequestSpecification;
    private static ResponseSpecification VideoGameResponseSpecification;

    @BeforeMethod
    public void setRequestSpecification() {
        VideoGameRequestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/app")
                .addHeader("Accept", "application/json")
                .build();
    }

    @BeforeMethod
    public void setResponseSpecification() {
        VideoGameResponseSpecification = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON).build();

    }

    @Test
    public void firstTest() {
        given()
                .spec(VideoGameRequestSpecification)
                .when()
                .get("/videogames")
                .then()
                .spec(VideoGameResponseSpecification)
                .log()
                .all();
    }
}