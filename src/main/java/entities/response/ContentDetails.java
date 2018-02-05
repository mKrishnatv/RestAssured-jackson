
package entities.response;

public class ContentDetails {

    private String Caption;
    private String Definition;
    private String Dimension;
    private String Duration;
    private Boolean LicensedContent;
    private String Projection;

    public String getCaption() {

        return this.Caption;
    }

    public void setCaption(String caption) {

        this.Caption = caption;
    }

    public String getDefinition() {

        return this.Definition;
    }

    public void setDefinition(String definition) {

        this.Definition = definition;
    }

    public String getDimension() {

        return this.Dimension;
    }

    public void setDimension(String dimension) {

        this.Dimension = dimension;
    }

    public String getDuration() {

        return this.Duration;
    }

    public void setDuration(String duration) {

        this.Duration = duration;
    }

    public Boolean getLicensedContent() {

        return this.LicensedContent;
    }

    public void setLicensedContent(Boolean licensedContent) {

        this.LicensedContent = licensedContent;
    }

    public String getProjection() {

        return this.Projection;
    }

    public void setProjection(String projection) {

        this.Projection = projection;
    }

}
