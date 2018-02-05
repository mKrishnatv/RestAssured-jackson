
package entities.response;

public class Thumbnails {

    private Default Default;
    private High High;
    private Maxres Maxres;
    private Medium Medium;
    private Standard Standard;

    public Default getDefault() {
        return this.Default;
    }

    public void setDefault(Default dflt) {
        this.Default = dflt;
    }

    public High getHigh() {
        return this.High;
    }

    public void setHigh(High high) {
        this.High = high;
    }

    public Maxres getMaxres() {
        return this.Maxres;
    }

    public void setMaxres(Maxres maxres) {
        this.Maxres = maxres;
    }

    public Medium getMedium() {
        return this.Medium;
    }

    public void setMedium(Medium medium) {
        this.Medium = medium;
    }

    public Standard getStandard() {
        return this.Standard;
    }

    public void setStandard(Standard standard) {
        this.Standard = standard;
    }

}
