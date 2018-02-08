package contract.test;

import entities.response.multiple.Item;
import entities.response.multiple.ResponseContainer;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import java.io.IOException;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class DataAttributesContractTests {

    @Test
    public void shouldHaveDataAttributes() throws IOException {
        String responseString =
                given()
                    .param("part", "snippet")
                    .param("id", "Ks-_Mh1QhMc")
                    .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0")
                .when()
                    .get("https://www.googleapis.com/youtube/v3/videos").asString();


        ObjectMapper mapper = new ObjectMapper();
        ResponseContainer responseRootObject = mapper.readValue(responseString, ResponseContainer.class);

        Item item = responseRootObject.getItems()[0];
        assertNotNull(item.getKind());
        assertNotNull(item.getEtag());
        assertNotNull(responseRootObject.getPageInfo());
        assertNotNull(responseRootObject.getItems());

    }
}
