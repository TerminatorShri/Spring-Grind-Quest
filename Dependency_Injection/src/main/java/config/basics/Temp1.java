package config.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Marks this class as a Spring bean so it can be scanned and managed
public class Temp1 {
    @Value( "Using Component Annotation" )
    private String tempVal;

    public String getTempVal() {
        return tempVal;
    }

    public void setTempVal(String tempVal) {
        this.tempVal = tempVal;
    }

    @Override
    public String toString() {
        return "Temp{ " +
                "tempVal='" + tempVal + '\'' +
                " }";
    }
}
