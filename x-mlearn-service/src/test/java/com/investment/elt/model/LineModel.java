package com.investment.elt.model;

public class LineModel {
    long row;
    int label;
    long date;
    int[] columnArray;
    double[] featureArray;

    public long getRow() {
        return row;
    }

    public void setRow(long row) {
        this.row = row;
    }

    public int[] getColumnArray() {
        return columnArray;
    }

    public void setColumnArray(int[] columnArray) {
        this.columnArray = columnArray;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }


    public double[] getFeatureArray() {
        return featureArray;
    }

    public void setFeatureArray(double[] featureArray) {
        this.featureArray = featureArray;
    }
}
