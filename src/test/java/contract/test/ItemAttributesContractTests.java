package contract.test;
import entities.response.multiple.Item;
import entities.response.multiple.ResponseContainer;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class ItemAttributesContractTests {

    static String responseString;

    @BeforeClass
    public static void beforeClass() throws IOException {
        responseString =
                given()
                        .param("part", "snippet")
                        .param("id", "Ks-_Mh1QhMc")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0")
                .when()
                        .get("https://www.googleapis.com/youtube/v3/videos").asString();
        System.out.println(responseString);
    }


    @Test
    public void shouldHaveItemAttributes() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ResponseContainer responseRootObject = mapper.readValue(responseString, ResponseContainer.class);

        Item item = responseRootObject.getItems()[0];

        assertNotNull(item.getKind());
        assertNotNull(item.getEtag());
        assertNotNull(item.getId());
        assertNotNull(item.getSnippet());
        assertNotNull(item.getSnippet().getPublishedAt());
        assertNotNull(item.getSnippet().getChannelId());
        assertNotNull(item.getSnippet().getTitle());
        assertNotNull(item.getSnippet().getDescription());
        assertNotNull(item.getSnippet().getThumbnails());
        assertNotNull(item.getSnippet().getTags());
        assertNotNull(item.getSnippet().getChannelTitle());
        assertNotNull(item.getSnippet().getCategoryId());
        assertNotNull(item.getSnippet().getLocalized());
        assertNotNull(item.getSnippet().getDefaultLanguage());
        assertNotNull(item.getSnippet().getDefaultAudioLanguage());
        assertNotNull(item.getSnippet().getLiveBroadcastContent());

    }
}
