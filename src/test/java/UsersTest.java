import dataEntity.Users.UsersResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test
    public void deserializationOfJson() {
        Response response = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/users");

        List<UsersResponse> usersResponses = Arrays.asList(response.as(UsersResponse[].class));
        String lng = usersResponses.get(0).getAddress().getGeo().getLng();
        String companyName = usersResponses.get(0).getCompany().getName();
        System.out.println("Address - geo - lng = " + lng);
        System.out.println("Company name is " + companyName);
    }
}
