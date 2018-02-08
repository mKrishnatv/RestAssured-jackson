package positive.tests;

import org.junit.Test;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

import java.util.Collections;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static com.jayway.restassured.path.json.JsonPath.from;

public class JsonPathIllustrationTests {

    @Test
    public void shouldReturnItemsBasedOnLocation() throws IOException {

        String responseString =
                given()
                        .param("part","snippet")
                        .param("location","21.5922529,-158.1147114")
                        .param("locationRadius","10mi")
                        .param("type","video")
                        .param("key","AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").

                when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();

        List<String> allItemsReturned = from(responseString).get("items");

        int itemsPerPage = from(responseString).get("pageInfo.resultsPerPage");

        assertEquals(allItemsReturned.size(), itemsPerPage);

    }

    @Test
    public void shouldReturnItemsOrderedbyDate() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet")
                        .param("location","21.5922529,-158.1147114")
                        .param("locationRadius","10mi")
                        .param("order", "date")
                        .param("type", "video")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();

        ArrayList<Date> dateList = from(responseString).get("items.snippet.publishedAt");

        ArrayList<Date> sortedDates = new ArrayList<Date>(dateList);
        Collections.sort(sortedDates);
        Collections.reverse(sortedDates);

        assertEquals(sortedDates, dateList);
    }
}
