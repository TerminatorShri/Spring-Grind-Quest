package org.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Temp {
    private int tempId;
    private String tempName;
    private List<String> tempValues;
    private Properties props;

    // Default ( No-arg ) Constructor needed for Creating a Bean using Setter Injection
    public Temp() {
        super();
        this.tempValues = new ArrayList<String>();
    }

    // Parameterized Constructor needed for Creating a Bean using Constructor Injection
    public Temp(int tempId, String tempName) {
        this.tempId = tempId;
        this.tempName = tempName;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public List<String> getTempValues() {
        return tempValues;
    }

    public void setTempValues(List<String> tempValues) {
        this.tempValues = tempValues;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Temp{ " +
                "tempId=" + tempId +
                ", tempName='" + tempName + '\'' +
                " }";
    }
}
