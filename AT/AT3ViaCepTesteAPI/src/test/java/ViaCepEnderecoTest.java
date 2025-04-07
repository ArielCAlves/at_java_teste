import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ViaCepEnderecoTest {

    @Test
    void enderecoCompletoComAcento() {
        given()
                .header("User-Agent", "Java Test")
                .urlEncodingEnabled(false)
                .get("https://viacep.com.br/ws/SP/S%C3%A3o%20Paulo/Avenida%20Paulista/json/")
                .then()
                .statusCode(200)
                .body("logradouro", hasItem(containsString("Paulista")));
    }

    @Test
    void enderecoCompletoSemAcento() {
        given()
                .header("User-Agent", "Java Test")
                .urlEncodingEnabled(false)
                .get("https://viacep.com.br/ws/SP/Sao%20Paulo/Avenida%20Paulista/json/")
                .then()
                .statusCode(200)
                .body("logradouro", hasItem(containsString("Paulista")));
    }

    @Test
    void cidadeInvalida() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/SP/CidadeInexistente/Avenida%20Paulista/json/")
                .then().statusCode(400);
    }

    @Test
    void logradouroInvalido() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/RJ/Niteroi/LogradouroQueNaoExiste123/json/")
                .then()
                .statusCode(200)
                .body("", hasSize(0));
    }

    @Test
    void ufInvalido() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/RJ/Sao%20Paulo/Avenida%20Paulista/json/")
                .then().statusCode(400);
    }

    @Test
    void ufVazio() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws//Sao%20Paulo/Avenida%20Paulista/json/")
                .then().statusCode(400);
    }

    @Test
    void cidadeVazia() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/SP//Avenida%20Paulista/json/")
                .then().statusCode(400);
    }

    @Test
    void logradouro() {
        given()
                .header("User-Agent", "Java Test")
                .get("https://viacep.com.br/ws/SP/Sao%20Paulo//json/")
                .then().statusCode(400);
    }

    @Test
    void cepComNoveDigitos() {
        given()
                .get("https://viacep.com.br/ws/123456789/json/")
                .then().statusCode(400);
    }

    @Test
    void cepComSeteDigitos() {
        given()
                .get("https://viacep.com.br/ws/1234567/json/")
                .then().statusCode(400);
    }

    @Test
    void logradouroComUmaLetra() {
        given()
                .get("https://viacep.com.br/ws/SP/Sao%20Paulo/A/json/")
                .then().statusCode(400);
    }

    @Test
    void cidadeComUmaLetra() {
        given()
                .get("https://viacep.com.br/ws/SP/A/Avenida%20Paulista/json/")
                .then().statusCode(400);
    }

}
