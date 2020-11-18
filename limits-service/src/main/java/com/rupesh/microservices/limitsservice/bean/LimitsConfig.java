package com.rupesh.microservices.limitsservice.bean;

public class LimitsConfig {

    private int minimum;
    private int maximum;

    public LimitsConfig(){}

    public LimitsConfig(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
