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

    private static String responseString;
    private static ObjectMapper mapper;
    private static ResponseContainer responseRootObject;
    private static Item item;


    @BeforeClass
    public static void beforeClass() throws IOException {
        responseString =
                given()
                        .param("part", "snippet")
                        .param("id", "Ks-_Mh1QhMc")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0")
                .when()
                        .get("https://www.googleapis.com/youtube/v3/videos").asString();
        mapper = new ObjectMapper();
        responseRootObject = mapper.readValue(responseString, ResponseContainer.class);

        item = responseRootObject.getItems()[0];
    }


    @Test
    public void shouldHaveItemAttributes() throws IOException {

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

    @Test
    public void shouldHaveThumbnailAttributes() throws IOException {

        assertNotNull(item.getSnippet().getThumbnails().getDefault());
        assertNotNull(item.getSnippet().getThumbnails().getHigh());
        assertNotNull(item.getSnippet().getThumbnails().getMaxres());
        assertNotNull(item.getSnippet().getThumbnails().getMedium());
        assertNotNull(item.getSnippet().getThumbnails().getStandard());

    }

    @Test
    public void shouldHaveTags() throws IOException {

        assertNotNull(item.getSnippet().getTags());
    }

    @Test
    public void shouldHaveLocalizedAttributes() throws IOException {

        assertNotNull(item.getSnippet().getLocalized().getDescription());
        assertNotNull(item.getSnippet().getLocalized().getTitle());

    }

}
