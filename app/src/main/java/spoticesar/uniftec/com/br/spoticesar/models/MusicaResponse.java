package spoticesar.uniftec.com.br.spoticesar.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MusicaResponse {

    @JsonProperty("data")
    private List<Musica> data;

    public List<Musica> getData() {
        return data;
    }

    public void setData(List<Musica> data) {
        this.data = data;
    }

}
