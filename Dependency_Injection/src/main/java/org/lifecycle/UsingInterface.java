package org.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UsingInterface implements InitializingBean, DisposableBean {
    private int tempId;

    public UsingInterface() {
        super();
    }

    public UsingInterface(int tempId) {
        this.tempId = tempId;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set called for Temp with ID UsingInterface: " + tempId);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy called for Temp with ID UsingInterface: " + tempId);
    }

    @Override
    public String toString() {
        return "UsingInterface{ " +
                "tempId=" + tempId +
                " }";
    }
}
