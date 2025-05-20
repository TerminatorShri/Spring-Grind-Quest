package org.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class UsingAnnotation {
    private int tempId;

    public UsingAnnotation() {
        super();
    }

    public UsingAnnotation(int tempId) {
        this.tempId = tempId;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    @Override
    public String toString() {
        return "UsingAnnotation{ " +
                "tempId=" + tempId +
                " }";
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method called for Temp with ID UsingAnnotation: " + tempId);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy method called for Temp with ID UsingAnnotation: " + tempId);
    }
}
