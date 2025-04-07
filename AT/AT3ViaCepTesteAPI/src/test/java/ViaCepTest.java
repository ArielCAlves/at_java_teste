import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ViaCepTest {

    @Test
    void cepVazio() {
        given().get("https://viacep.com.br/ws//json/")
                .then()
                .statusCode(400);
    }

    @Test
    void cepComLetras() {
        given().get("https://viacep.com.br/ws/abc12345/json/")
                .then()
                .statusCode(400);
    }

    @Test
    void cepCurtoInvalido() {
        given().get("https://viacep.com.br/ws/123/json/")
                .then()
                .statusCode(400);
    }

    @Test
    void cepNumericoInexistente() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/00000000/json/")
                .then()
                .statusCode(200)
                .body("erro", equalTo("true"));
    }
}
