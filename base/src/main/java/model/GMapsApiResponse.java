package model;

import java.util.List;

public class GMapsApiResponse {

    List<GMapsApiResult> results;
    String status;

    public List<GMapsApiResult> getResults() {
        return results;
    }

    public void setResults(List<GMapsApiResult> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
