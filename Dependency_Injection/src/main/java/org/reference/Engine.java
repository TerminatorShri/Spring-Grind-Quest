package org.reference;

public class Engine {
    private String engineType;

    public Engine() {
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Engine{ " +
                "engineType='" + engineType + '\'' +
                " }";
    }
}
