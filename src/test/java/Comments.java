import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Comments {

    @Test
    void testGet() {
        given().when().get(K.COMMENTS_LOCATION).then().log().all();
    }

    @Test
    void returnByID() {
        given().when().get(K.findID(1)).then().log().all();
    }

    @Test
    void putNewID() {
        given().contentType(ContentType.JSON).body(K.createComments("rotem", "rotem@gmail.com", "bla bla bla")).when();
    }

    @Test
    void deleteComments() {
        given().when().delete(K.findID(2)).then().statusCode(404);
    }
}

