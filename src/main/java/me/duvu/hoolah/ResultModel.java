package me.duvu.hoolah;

import java.io.Serializable;

public class ResultModel implements Serializable {

    private String merchant;
    private long fromTimestamp;
    private long toTimestamp;

    private int numberOfTrans;
    private double totalTransValue;

    public ResultModel(String merchant) {
        this.merchant = merchant;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public long getFromTimestamp() {
        return fromTimestamp;
    }

    public void setFromTimestamp(long fromTimestamp) {
        this.fromTimestamp = fromTimestamp;
    }

    public long getToTimestamp() {
        return toTimestamp;
    }

    public void setToTimestamp(long toTimestamp) {
        this.toTimestamp = toTimestamp;
    }

    public int getNumberOfTrans() {
        return numberOfTrans;
    }

    public void setNumberOfTrans(int numberOfTrans) {
        this.numberOfTrans = numberOfTrans;
    }

    public double getTotalTransValue() {
        return totalTransValue;
    }

    public void setTotalTransValue(double totalTransValue) {
        this.totalTransValue = totalTransValue;
    }

    public void addTransValue(double transValue) {
        totalTransValue += transValue;
        numberOfTrans ++;
    }

    public double getAverageTransValue() {

        return getNumberOfTrans() > 0 ? getTotalTransValue() / getNumberOfTrans() : 0;
    }
}
