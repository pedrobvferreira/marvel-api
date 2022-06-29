package marvel.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MarvelResponse {

    private String status;
    private String attributionHTML;
    private DataResponse data;

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public String getAttributionHTML() {

        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {

        this.attributionHTML = attributionHTML;
    }

    public DataResponse getData() {

        return data;
    }

    public void setData(DataResponse data) {

        this.data = data;
    }
}
