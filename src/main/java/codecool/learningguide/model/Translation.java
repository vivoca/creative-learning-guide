package codecool.learningguide.model;

import java.io.Serializable;

public class Translate implements Serializable {
    private static final long serialVersionUID = 1L;
    long transId;
    String hungarian;
    String foreign;

    public Translate(){
    }

    public Translate(long transId, String hungarian, String foreign)     {
        this.transId = transId;
        this.hungarian = hungarian;
        this.foreign = foreign;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
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
        return "Translate [transId=" + transId +
                ", hungarian=" + hungarian +
                ", foreign=" + foreign + "]";
    }
}
