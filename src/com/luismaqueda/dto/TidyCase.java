package com.luismaqueda.dto;

import java.util.List;

public class TidyCase {

    private int numberOfCases;
    private List<Long> theCases;

    public TidyCase() {
    }

    public TidyCase(int numberOfCases, List<Long> theCases) {
        this.numberOfCases = numberOfCases;
        this.theCases = theCases;
    }

    public List<Long> getTheCases() {
        return theCases;
    }

    public void setTheCases(List<Long> theCases) {
        this.theCases = theCases;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }
}
