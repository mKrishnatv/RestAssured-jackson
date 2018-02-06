package positive.tests;

import entities.response.multiple.ResponseContainer;
import entities.response.multiple.Item;
import org.codehaus.jackson.map.ObjectMapper;
import entities.response.ResponseHelper;
import org.junit.BeforeClass;
import org.junit.Test;
import styles.tests.Styles;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class JacksonObjectMapperIllustrationTests {

     private static ResponseContainer responseContainer;

    @BeforeClass
    public static void beforeClass() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet,contentDetails,statistics")
                        .param("id","Ks-_Mh1QhMc")
                        .param("key","AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                        .get("https://www.googleapis.com/youtube/v3/videos").asString();

        ObjectMapper mapper = new ObjectMapper();
        responseContainer = mapper.readValue(responseString, ResponseContainer.class);

    //  responseContainer = (ResponseContainer) ResponseHelper.getResponseAsObject(responseString, ResponseContainer.class);
    }

    @Test
    public void assertResponseContainerAttributes() {
        assertEquals(1, responseContainer.getPageInfo().getTotalResults());
        assertEquals(1, responseContainer.getPageInfo().getResultsPerPage());
    }

    @Test
    public void assertItemAttributes() {
       // System.out.println(responseContainer.getItems().length);
        Item item = responseContainer.getItems()[0];
        assertEquals("Ks-_Mh1QhMc", item.getId());
        assertEquals("youtube#video", item.getKind());
    }
    @Test
    public void assertSnippetAttributes() {
        Item item = responseContainer.getItems()[0];
        assertEquals("2018-02-03T05:07:54.000Z", item.getSnippet().getPublishedAt());
        assertEquals("UCblfuW_4rakIf2h6aqANefA", item.getSnippet().getChannelId());
        assertEquals("Surfing LIVE - Volcom Pipe Pro 2018 - Day 3", item.getSnippet().getTitle());
        assertEquals("Watch Volcom Pipe Pro 2018 Day 3 LIVE from Oahu, Hawaii. Experience the world of Red Bull like you have never seen it before. With the...", item.getSnippet().getDescription());
        assertEquals("Red Bull", item.getSnippet().getChannelTitle());
        assertEquals("none", item.getSnippet().getLiveBroadcastContent());

    }
}
