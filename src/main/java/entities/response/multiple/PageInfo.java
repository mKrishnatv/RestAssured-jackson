
package entities.response.multiple;

public class PageInfo {

    private Number ResultsPerPage;
    private Number TotalResults;

    public Number getResultsPerPage() {

        return this.ResultsPerPage;
    }

    public void setResultsPerPage(Number resultsPerPage) {

        this.ResultsPerPage = resultsPerPage;
    }

    public Number getTotalResults() {

        return this.TotalResults;
    }

    public void setTotalResults(Number totalResults) {

        this.TotalResults = totalResults;
    }

}
