package spoticesar.uniftec.com.br.spoticesar.generics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import spoticesar.uniftec.com.br.spoticesar.R;

public class GenericEntity
        implements Serializable {

    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return null;
    }

    private int imageId;
    public int getImageId() {
        return R.drawable.imagi;
    }

}
