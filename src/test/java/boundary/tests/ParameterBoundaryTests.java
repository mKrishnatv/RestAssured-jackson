package boundary.tests;

import entities.response.ResponseHelper;
import entities.response.multiple.ResponseContainer;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class ParameterBoundaryTests {

    @Test
    public void shouldReturn0ItemsWhenMaxResultsIsSpecifiedAs0() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet")
                        .param("maxResults", "0")
                        .param("q", "")
                        .param("type", "")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();

        ObjectMapper mapper = new ObjectMapper();
        ResponseContainer responseContainer = mapper.readValue(responseString, ResponseContainer.class);
        assertEquals(0, responseContainer.getItems().length);
    }

    @Test
    public void shouldReturn50ItemsWhenMaxResultsIsSpecifiedAs50() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet")
                        .param("maxResults", "50")
                        .param("q", "")
                        .param("type", "")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();

        entities.response.ResponseContainer responseContainer = (entities.response.ResponseContainer) ResponseHelper.getResponseAsObject(responseString, entities.response.ResponseContainer.class);

        assertEquals(50, responseContainer.getItems().length);
    }

    @Test
    public void shouldReturnErrorWhenItemsRequestedis51() {
        given()
                .param("part", "snippet")
                .param("maxResults", "51")
                .param("q", "")
                .param("type", "")
                .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
        when()
                .get("https://www.googleapis.com/youtube/v3/search").
        then()
                .assertThat().body("error.code", equalTo(400)).and()
                .assertThat().body("error.message", equalTo("Invalid value '51'. Values must be within the range: [0, 50]"));

    }

    @Test
    public void shouldReturnErrorWhenItemsRequestedIsMinus1() {
        given()
                .param("part", "snippet")
                .param("maxResults", "-1")
                .param("q", "")
                .param("type", "")
                .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
        when()
                .get("https://www.googleapis.com/youtube/v3/search").
        then()
                .assertThat().body("error.code", equalTo(400)).and()
                .assertThat().body("error.message", equalTo("Invalid unsigned integer value: '-1'."));

    }

}
