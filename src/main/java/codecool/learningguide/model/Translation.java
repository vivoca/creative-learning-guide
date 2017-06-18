package codecool.learningguide.model;

import java.io.Serializable;

public class Translation implements Serializable {
    private static final long serialVersionUID = 1L;
    int transId;
    String hungarian;
    String foreign;

    public Translation(){
    }

    public Translation(int transId, String hungarian, String foreign)     {
        this.transId = transId;
        this.hungarian = hungarian;
        this.foreign = foreign;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getHungarian() {
        return hungarian;
    }

    public void setHungarian(String name) {
        this.hungarian = name;
    }

    public String getForeign() {
        return foreign;
    }

    public void setForeign(String foreign) {
        this.foreign = foreign;
    }

    @Override
    public String toString() {
        return "Translation [transId=" + transId +
                ", hungarian=" + hungarian +
                ", foreign=" + foreign + "]";
    }
}
