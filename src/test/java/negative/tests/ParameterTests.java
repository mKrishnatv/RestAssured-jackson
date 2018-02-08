package negative.tests;

import entities.response.ResponseContainer;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import java.io.IOException;
import static com.jayway.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class ParameterTests {

    @Test
    public void shouldReturn0ItemsWhenVideoIdIsIncorrect() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet,contentDetails,statistics")
                        .param("id","Ks-_Mh")
                        .param("key","AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").

                when()
                        .get("https://www.googleapis.com/youtube/v3/videos").asString();

        ObjectMapper mapper = new ObjectMapper();
        ResponseContainer responseContainer = mapper.readValue(responseString, ResponseContainer.class);
        assertEquals(0, responseContainer.getPageInfo().getTotalResults());
    }

    @Test
    public void shouldReturnErrorWhenLocationIsInvalid() {
        given()
                .param("part", "snippet")
                .param("location","0")
                .param("locationRadius", "5mi")
                .param("q", "")
                .param("type", "video")
                .param("key","AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
        when()
                .get("https://www.googleapis.com/youtube/v3/search").
        then()
                .assertThat().body("error.code", equalTo(400)).and()
                .assertThat().body("error.message", equalTo("Invalid location."));
    }

}
