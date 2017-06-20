package codecool.learningguide.model;


public class Translation implements Comparable<Translation> {
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
    public int compareTo(Translation other){
        if (getTransId() > other.getTransId()) {
            return 1;
        } else if (getTransId() < other.getTransId()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Translation [transId=" + transId +
                ", hungarian=" + hungarian +
                ", foreign=" + foreign + "]";
    }
}
