package spoticesar.uniftec.com.br.spoticesar.generics;

import java.io.Serializable;

import spoticesar.uniftec.com.br.spoticesar.R;

public class GenericEntity
        implements Serializable {

    private int imageId;

    public int getImageId() {
        return R.drawable.imagi;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}
