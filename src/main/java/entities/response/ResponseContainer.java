
package entities.response;

public class ResponseContainer {

    private String Etag;
    private Item[] Items;
    //private ItemIds[] ItemsIds;
    private String Kind;
    private entities.response.PageInfo PageInfo;
    private String nextPageToken;
    private String regionCode;

    public String getEtag() {
        return this.Etag;
    }

    public void setEtag(String etag) {
        this.Etag = etag;
    }

    public Item[] getItems() {
        return this.Items;
    }

    public void setItems(Item[] items) {
        this.Items = items;
    }

//    public ItemIds[] getItemsIds() {
//        return this.ItemsIds;
//    }
//
//    public void setItemsIds(ItemIds[] items) {
//        this.ItemsIds = items;
//    }

    public String getKind() {
        return this.Kind;
    }

    public void setKind(String kind) {
        this.Kind = kind;
    }

    public entities.response.PageInfo getPageInfo() {
        return this.PageInfo;
    }

    public void setPageInfo(entities.response.PageInfo pageInfo) {
        this.PageInfo = pageInfo;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
