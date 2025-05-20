package org.lifecycle;

public class UsingCallbacks {
    private int tempId;

    public UsingCallbacks() {}

    public UsingCallbacks(int tempId) {
        this.tempId = tempId;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public void init() {
        System.out.println("Init method called for Temp with ID UsingCallbacks: " + tempId);
    }

    public void destroy() {
        System.out.println("Destroy method called for Temp with ID UsingCallbacks: " + tempId);
    }

    @Override
    public String toString() {
        return "Temp{ " +
                "tempId = " + tempId +
                " }";
    }
}
