
package entities.response.multiple;


public class Item {

    private entities.response.ContentDetails ContentDetails;
    private String Etag;
    //@JsonProperty("id")
    private String Id;
    private String Kind;
    private entities.response.Snippet Snippet;
    private entities.response.Statistics Statistics;

    public entities.response.ContentDetails getContentDetails() {
        return this.ContentDetails;
    }

    public void setContentDetails(entities.response.ContentDetails contentDetails) {
        this.ContentDetails = contentDetails;
    }

    public String getEtag() {
        return this.Etag;
    }

    public void setEtag(String etag) {
        this.Etag = etag;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

//    public Id getIds() {
//        return this.id;
//    }
//
//    public void setIds(Id id) {
//        this.id = id;
//    }

    public String getKind() {
        return this.Kind;
    }

    public void setKind(String kind) {
        this.Kind = kind;
    }

    public entities.response.Snippet getSnippet() {
        return this.Snippet;
    }

    public void setSnippet(entities.response.Snippet snippet) {
        this.Snippet = snippet;
    }

    public entities.response.Statistics getStatistics() {
        return this.Statistics;
    }

    public void setStatistics(entities.response.Statistics statistics) {
        this.Statistics = statistics;
    }

}
