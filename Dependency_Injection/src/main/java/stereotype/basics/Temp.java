package stereotype.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

// Registers this class as a Spring bean with the custom ID "customBeanName"
@Component("customBeanName")
public class Temp {

    // Injects the value "Shriyash" into the tempName field during bean creation
    @Value("Shriyash")
    private String tempName;

    // Injects the list bean with ID 'tempList' defined in XML into the tempValues field
    // The syntax "#{beanName}" is SpEL (Spring Expression Language) used for referencing other beans
    @Value("#{tempList}")
    private ArrayList<String> tempValues;

    // Injects the result of evaluating the static method Math.sqrt(36), i.e., 6.0 (auto-converted to int)
    @Value("#{T(java.lang.Math).sqrt(36)}")
    private int calculatedValue;

    // Injects a new String object with the value "Shriyash" using Spring Expression Language (SpEL)
    @Value("#{ new java.lang.String('Shriyash') }")
    private String objectName;

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public ArrayList<String> getTempValues() {
        return tempValues;
    }

    public void setTempValues(ArrayList<String> tempValues) {
        this.tempValues = tempValues;
    }

    public int getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(int calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "Temp{ " +
                "tempName='" + tempName + '\'' +
                ", tempValues=" + tempValues +
                ", calculatedValue=" + calculatedValue +
                ", objectName='" + objectName + '\'' +
                " }";
    }
}
