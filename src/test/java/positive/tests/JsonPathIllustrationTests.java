package positive.tests;

import org.junit.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static com.jayway.restassured.path.json.JsonPath.from;
//import io.restassured.response.Response;

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

        int itemsPerPage = from(responseString).get("pageInfo.ResultsPerPage");
        assertEquals(allItemsReturned.size(), itemsPerPage);

    }
/*
    @Test
    public void shouldReturnItemsOrderedbyRating() throws IOException {
        String responseString =
                given()
                        .param("part", "snippet,contentDetails,statistics")
                        .param("location","21.5922529,-158.1147114")
                        .param("locationRadius","10mi")
                        .param("order", "rating")
                        .param("type", "video")
                        .param("key", "AIzaSyD9FNFFLje1rFT4Yaq1JbP_6NxA84NzVB0").
                when()
                        .get("https://www.googleapis.com/youtube/v3/search").asString();
        System.out.println(responseString);


    }



    @Test
    public void shouldReturnItemsOrderedByRating() throws IOException {

        String responseString =
                given()
                    .param("author", "krishnamohan777")
                    .param("orderby", "rating")
                    .param("v", "2")
                    .param("alt", "jsonc").
                when()
                    .get("http://gdata.youtube.com/feeds/api/videos").asString();

        ArrayList<Double> ratings = from(responseString).get("data.items.rating");
        ratings.removeAll(Collections.singleton(null));

        ArrayList<Double> sortedRatings = new ArrayList<Double>(ratings);
        Collections.sort(sortedRatings);
        Collections.reverse(sortedRatings);

        assertEquals(sortedRatings, ratings);

    }
    */
}
