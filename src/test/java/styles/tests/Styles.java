package styles.tests;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import java.io.IOException;
import entities.response.ResponseContainer;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;

public class Styles {

    @Test
    public void shouldReturnOneItem() {
        get("https://www.googleapis.com/youtube/v3/videos?part=snippet,contentDetails,statistics&id=Ks-_Mh1QhMc&key=AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0")
                .then()
                .assertThat()
                .body("pageInfo.totalResults", equalTo(1));
    }

    @Test
    public void shouldAlsoReturnOneItem() {
        given()
                .param("part", "snippet,contentDetails,statistics")
                .param("id","Ks-_Mh1QhMc")
                .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                .get("https://www.googleapis.com/youtube/v3/videos").
                then()
                .body("pageInfo.totalResults", equalTo(1));
    }

    @Test
    public void shouldReturnOneItemToo() {
        String responseString =
                given()
                        .param("part", "snippet,contentDetails,statistics")
                        .param("id","Ks-_Mh1QhMc")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                        when()
                        .get("https://www.googleapis.com/youtube/v3/videos").asString();

        //System.out.println(responseString);
        int totalItems = from(responseString).get("pageInfo.totalResults");

        assertEquals(1, totalItems);

    }

    @Test
    public void shouldReturnTwoItems() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet")
                        .param("maxResults", "2")
                        .param("q", "surfing")
                        .param("type", "")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                        when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();

        //System.out.println(responseString);
        //System.out.println(responseString);

        ResponseContainer responseContainer = (ResponseContainer) getResponseAsObject(responseString, ResponseContainer.class);

       // ObjectMapper mapper = new ObjectMapper();
       // ResponseContainer responseContainer = mapper.readValue(responseString, ResponseContainer.class);

        assertEquals(2, responseContainer.getItems().length);
    }

    public static Object getResponseAsObject(String responseString, Class responseClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(responseString, responseClass);
    }

}
