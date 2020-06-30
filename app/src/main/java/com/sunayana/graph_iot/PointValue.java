package com.sunayana.graph_iot;

public class PointValue {
    int xValue, y1Value, y2Value;

    public PointValue() {
    }

    public PointValue(int xValue, int y1Value, int y2Value) {
        this.xValue = xValue;
        this.y1Value = y1Value;
        this.y2Value = y2Value;
    }

    public int getxValue() {
        return xValue;
    }

    public int gety1Value() {
        return y1Value;
    }

    public int gety2Value() {
        return y2Value;
    }
}

