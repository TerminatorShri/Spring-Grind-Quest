package config.basics;

import org.springframework.beans.factory.annotation.Value;

public class Temp2 {
    @Value("Using Bean Annotation")
    private String tempVal;

    public String getTempVal() {
        return tempVal;
    }

    public void setTempVal(String tempVal) {
        this.tempVal = tempVal;
    }

    @Override
    public String toString() {
        return "Temp2{ " +
                "tempVal='" + tempVal + '\'' +
                " }";
    }
}
