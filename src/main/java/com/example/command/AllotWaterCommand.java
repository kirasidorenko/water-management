package com.example.command;

import com.example.visitor.WaterBillVisitor;

public class AllotWaterCommand implements Command {

    private int numberOfBedrooms;
    private int ratioCorpWater;
    private int ratioBorewellWater;

    public AllotWaterCommand(int numberOfBedrooms, int ratioCorpWater, int ratioBorewellWater) {
        this.numberOfBedrooms = numberOfBedrooms;
        this.ratioCorpWater = ratioCorpWater;
        this.ratioBorewellWater = ratioBorewellWater;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public int getRatioCorpWater() {
        return ratioCorpWater;
    }

    public int getRatioBorewellWater() {
        return ratioBorewellWater;
    }

    @Override
    public void execute(WaterBillVisitor waterBillVisitor) {
        waterBillVisitor.visit(this);
    }
}
