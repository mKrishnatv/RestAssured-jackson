
package entities.response;

import java.util.List;

public class Snippet {

    private String CategoryId;
    private String ChannelId;
    private String ChannelTitle;
    private String DefaultAudioLanguage;
    private String DefaultLanguage;
    private String Description;
    private String LiveBroadcastContent;
    private entities.response.Localized Localized;
    private String PublishedAt;
    private List<String> Tags;
    private entities.response.Thumbnails Thumbnails;
    private String Title;

    public String getCategoryId() {
        return this.CategoryId;
    }

    public void setCategoryId(String categoryId) {
        this.CategoryId = categoryId;
    }

    public String getChannelId() {
        return this.ChannelId;
    }

    public void setChannelId(String channelId) {
        this.ChannelId = channelId;
    }

    public String getChannelTitle() {
        return this.ChannelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.ChannelTitle = channelTitle;
    }

    public String getDefaultAudioLanguage() {
        return this.DefaultAudioLanguage;
    }

    public void setDefaultAudioLanguage(String defaultAudioLanguage) {
        this.DefaultAudioLanguage = defaultAudioLanguage;
    }

    public String getDefaultLanguage() {
        return this.DefaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.DefaultLanguage = defaultLanguage;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getLiveBroadcastContent() {
        return this.LiveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.LiveBroadcastContent = liveBroadcastContent;
    }

    public entities.response.Localized getLocalized() {
        return this.Localized;
    }

    public void setLocalized(entities.response.Localized localized) {
        this.Localized = localized;
    }

    public String getPublishedAt() {
        return this.PublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.PublishedAt = publishedAt;
    }

    public List<String> getTags() {
        return this.Tags;
    }

    public void setTags(List<String> tags) {
        this.Tags = tags;
    }

    public entities.response.Thumbnails getThumbnails() {
        return this.Thumbnails;
    }

    public void setThumbnails(entities.response.Thumbnails thumbnails) {
        this.Thumbnails = thumbnails;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

}
