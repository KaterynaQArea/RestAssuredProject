import dataEntity.VideoGame.VGResponse;
import dataEntity.VideoGame.VideoGameResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VideoGamesRestAssuredTests {


    private static RequestSpecification VideoGameRequestSpecification;
    private static ResponseSpecification VideoGameResponseSpecification;

    @BeforeMethod
    public void setRequestSpecification() {
        VideoGameRequestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/app")
                .addHeader("Accept", "application/json")
                .setContentType(ContentType.JSON)
                .build();
    }

    @BeforeMethod
    public void setResponseSpecification() {
        VideoGameResponseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void getAllGames() {

        Response response = given()
                .spec(VideoGameRequestSpecification)
                .when()
                .get("/videogames");
        response.then()
                .spec(VideoGameResponseSpecification)
                .log()
                .all();

        System.out.println("Response time in milliseconds: " + response.getTime());
    }

    @Test
    public void createNewVideoGameUsingJson() {

        String gameBodyJson = "{\n" +
                "  \"id\": 20,\n" +
                "  \"name\": \"MyNewGame_20\",\n" +
                "  \"releaseDate\": \"2019-12-03\",\n" +
                "  \"reviewScore\": 89,\n" +
                "  \"category\": \"Shooter\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given()
                .spec(VideoGameRequestSpecification)
                .body(gameBodyJson)
                .when()
                .post("/videogames")
                .then()
                .log()
                .body();
    }

    @Test
    public void createNewVideoGameUsingSerialisationJsonRequest() {
        VideoGameResponse videoGameResponse = new VideoGameResponse(21, "My Awesome Game_21", "2018-04-04", 121, "Shooter", "Mature");
        given()
                .spec(VideoGameRequestSpecification)
                .body(videoGameResponse)
                .when()
                .post("/videogames")
                .then()
                .log()
                .body();
    }

    @Test
    public void getVideoGameById() {

        Response response = given()
                .spec(VideoGameRequestSpecification)
                .when()
                .get("videogames/2");

        VGResponse vGResponse = response.as(VGResponse.class);
        int id = vGResponse.getId();
        System.out.println("ID = " + id);
    }

    @Test
    public void updateNameAndCategory() {
        String newGameBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2019-12-03T10:02:58.768Z\",\n" +
                "  \"reviewScore\": 77,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Universal\"\n" +
                "}";
        given()
                .spec(VideoGameRequestSpecification)
                .body(newGameBody)
                .when()
                .put("videogames/1")
                .then()
                .log()
                .all();
    }
}
