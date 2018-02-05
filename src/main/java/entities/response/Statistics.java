
package entities.response;
public class Statistics {

    private String CommentCount;
    private String DislikeCount;
    private String FavoriteCount;
    private String LikeCount;
    private String ViewCount;

    public String getCommentCount() {
        return this.CommentCount;
    }

    public void setCommentCount(String commentCount) {
        this.CommentCount = commentCount;
    }

    public String getDislikeCount() {
        return this.DislikeCount;
    }

    public void setDislikeCount(String dislikeCount) {
        this.DislikeCount = dislikeCount;
    }

    public String getFavoriteCount() {
        return this.FavoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.FavoriteCount = favoriteCount;
    }

    public String getLikeCount() {
        return this.LikeCount;
    }

    public void setLikeCount(String likeCount) {
        this.LikeCount = likeCount;
    }

    public String getViewCount() {
        return this.ViewCount;
    }

    public void setViewCount(String viewCount) {
        this.ViewCount = viewCount;
    }

}
