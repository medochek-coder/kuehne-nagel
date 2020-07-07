package com.kulygina.model;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(propOrder = {"sportsmanName", "run100m", "longJump", "shotPut", "highJump", "run400m", "run110mHurdles",
        "discusThrow", "poleVault", "javelinThrow", "run1500m", "totalScore", "place"})
public class DecathlonResultModel {
    private String sportsmanName;
    private double run100m;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double run400m;
    private double run110mHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private double run1500m;
    private int totalScore;
    private String place;

    public DecathlonResultModel() {
    }

    public DecathlonResultModel(String sportsmanName, double run100m, double longJump, double shotPut, double highJump,
                                double run400m, double run110mHurdles, double discusThrow, double poleVault,
                                double javelinThrow, double run1500m) {
        this.sportsmanName = sportsmanName;
        this.run100m = run100m;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.run400m = run400m;
        this.run110mHurdles = run110mHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.run1500m = run1500m;
    }

    public DecathlonResultModel(String sportsmanName, double run100m, double longJump, double shotPut, double highJump,
                                double run400m, double run110mHurdles, double discusThrow, double poleVault,
                                double javelinThrow, double run1500m, int totalScore, String place) {
        this.sportsmanName = sportsmanName;
        this.run100m = run100m;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.run400m = run400m;
        this.run110mHurdles = run110mHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.run1500m = run1500m;
        this.totalScore = totalScore;
        this.place = place;
    }

    public String getSportsmanName() {
        return sportsmanName;
    }

    public void setSportsmanName(String sportsmanName) {
        this.sportsmanName = sportsmanName;
    }

    public double getRun100m() {
        return run100m;
    }

    public void setRun100m(double run100m) {
        this.run100m = run100m;
    }

    public double getLongJump() {
        return longJump;
    }

    public void setLongJump(double longJump) {
        this.longJump = longJump;
    }

    public double getShotPut() {
        return shotPut;
    }

    public void setShotPut(double shotPut) {
        this.shotPut = shotPut;
    }

    public double getHighJump() {
        return highJump;
    }

    public void setHighJump(double highJump) {
        this.highJump = highJump;
    }

    public double getRun400m() {
        return run400m;
    }

    public void setRun400m(double run400m) {
        this.run400m = run400m;
    }

    public double getRun110mHurdles() {
        return run110mHurdles;
    }

    public void setRun110mHurdles(double run110mHurdles) {
        this.run110mHurdles = run110mHurdles;
    }

    public double getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(double discusThrow) {
        this.discusThrow = discusThrow;
    }

    public double getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(double poleVault) {
        this.poleVault = poleVault;
    }

    public double getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(double javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public double getRun1500m() {
        return run1500m;
    }

    public void setRun1500m(double run1500m) {
        this.run1500m = run1500m;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "DecathlonInputResultModel{" +
                "sportsmanName='" + sportsmanName + '\'' +
                ", run100m=" + run100m +
                ", longJump=" + longJump +
                ", shotPut=" + shotPut +
                ", highJump=" + highJump +
                ", run400m=" + run400m +
                ", run110mHurdles=" + run110mHurdles +
                ", discusThrow=" + discusThrow +
                ", poleVault=" + poleVault +
                ", javelinThrow=" + javelinThrow +
                ", run1500m=" + run1500m +
                ", totalScore=" + totalScore +
                ", place='" + place + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecathlonResultModel that = (DecathlonResultModel) o;
        return Double.compare(that.run100m, run100m) == 0 &&
                Double.compare(that.longJump, longJump) == 0 &&
                Double.compare(that.shotPut, shotPut) == 0 &&
                Double.compare(that.highJump, highJump) == 0 &&
                Double.compare(that.run400m, run400m) == 0 &&
                Double.compare(that.run110mHurdles, run110mHurdles) == 0 &&
                Double.compare(that.discusThrow, discusThrow) == 0 &&
                Double.compare(that.poleVault, poleVault) == 0 &&
                Double.compare(that.javelinThrow, javelinThrow) == 0 &&
                Double.compare(that.run1500m, run1500m) == 0 &&
                totalScore == that.totalScore &&
                Objects.equals(sportsmanName, that.sportsmanName) &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportsmanName, run100m, longJump, shotPut, highJump, run400m, run110mHurdles, discusThrow,
                poleVault, javelinThrow, run1500m, totalScore, place);
    }
}
