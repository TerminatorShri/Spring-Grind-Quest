package config.basics;

public class Temp3 {
    private Temp2 temp2;

    public Temp3(Temp2 temp2) {
        this.temp2 = temp2;
    }

    public Temp2 getTemp2() {
        return temp2;
    }

    public void setTemp2(Temp2 temp2) {
        this.temp2 = temp2;
    }

    @Override
    public String toString() {
        return "Temp3{ " +
                "temp2=" + temp2 +
                " }";
    }
}
