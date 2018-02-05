package positive.tests;

import entities.response.ResponseContainer;

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

      /*  ObjectMapper mapper = new ObjectMapper();
        responseContainer = mapper.readValue(responseString, ResponseContainer.class); */
      responseContainer = (ResponseContainer) Styles.getResponseAsObject(responseString, ResponseContainer.class);
    }

    @Test
    public void assertResponseContainerAttributes() {
        assertEquals(1, responseContainer.getPageInfo().getTotalResults());
       // assertEquals(1, responseContainer.getData().getStartIndex());
        assertEquals(1, responseContainer.getPageInfo().getResultsPerPage());
    }

//    @Test
//    public void assertItemAttributes() {
//        System.out.println(responseContainer.getItems().length);
//        ItemIds itemIds = responseContainer.getItems()[0];
//        assertEquals("Ks-_Mh1QhMc", item.);
//        assertEquals("krishnamohan777", item.getUploader());
//        assertEquals("Entertainment", item.getCategory());
//        assertEquals("Maa thujhe salaam song on the stage by A R Rehman", item.getTitle());
//        assertEquals(288, item.getDuration());
//    }
/*
    @Test
    public void assertRestrictionAttributes() {
        Restriction restriction = responseContainer.getData().getItems().get(0).getRestrictions().get(0);
        assertEquals("country", restriction.getType());
        assertEquals("deny", restriction.getRelationship());
        assertEquals("DE", restriction.getCountries());
    }
    */
}
