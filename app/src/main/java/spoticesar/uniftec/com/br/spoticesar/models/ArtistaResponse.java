package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistaResponse {

    @JsonProperty("data")
    private List<Artista> data;

    public List<Artista> getData() {
        return data;
    }

    public void setData(List<Artista> data) {
        this.data = data;
    }

}
