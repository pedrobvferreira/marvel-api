package marvelapi.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DataResponse {

    private List<ResultsResponse> results;

    public List<ResultsResponse> getResults() {

        return results;
    }

    public void setResults(List<ResultsResponse> results) {

        this.results = results;
    }
}
