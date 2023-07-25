package com.example.visitor;

import com.example.command.AddGuestsCommand;
import com.example.command.AllotWaterCommand;
import com.example.command.BillCommand;

import static com.example.constant.Constants.*;
import static com.example.constant.Constants.WATER_PER_MONTH_PER_PERSON;

public class WaterBillVisitor {
    private int corpWaterInLitres;
    private int borewellWaterInLitres;
    private int tankerWaterInLitres;

    private int totalWaterInLitres;
    private int totalCost;

    public void visit(AllotWaterCommand command) {
        int people = command.getNumberOfBedrooms() == TWO_BEDROOM_APARTMENT ? TWO_BEDROOM_CAPACITY : THREE_BEDROOM_CAPACITY;
        int litresOfWater = people * WATER_PER_MONTH_PER_PERSON;
        int litresPerRatio = litresOfWater / (command.getRatioCorpWater() + command.getRatioBorewellWater());
        this.corpWaterInLitres = litresPerRatio * command.getRatioCorpWater();
        this.borewellWaterInLitres = litresOfWater - this.corpWaterInLitres;
    }

    public void visit(AddGuestsCommand command) {
        this.tankerWaterInLitres += command.getNumberOfGuests() * WATER_PER_MONTH_PER_PERSON;
    }

    public void visit(BillCommand command) {
        this.totalWaterInLitres = this.corpWaterInLitres + this.borewellWaterInLitres + this.tankerWaterInLitres;
        double costOfCorp = this.corpWaterInLitres * PRICE_PER_LITRE_OF_CORP_WATER;
        double costOfBorewell = this.borewellWaterInLitres * PRICE_PER_LITRE_OF_BOREWELL_WATER;
        double costOfTanker = 0;
        int tankerWaterInLitres = this.tankerWaterInLitres;
        if (tankerWaterInLitres < 501) {
            costOfTanker = tankerWaterInLitres * 2;
        } else if (tankerWaterInLitres < 1501) {
            costOfTanker = 500 * 2 + (tankerWaterInLitres - 500) * 3;
        } else if (tankerWaterInLitres < 3001) {
            costOfTanker = 500 * 2 + 1000 * 3 + (tankerWaterInLitres - 1500) * 5;
        } else {
            costOfTanker = 500 * 2 + 1000 * 3 + 1500 * 5 + (tankerWaterInLitres - 3000) * 8;
        }
        this.totalCost = (int)(costOfCorp + costOfBorewell + costOfTanker);
        System.out.println(this.totalWaterInLitres + " " + this.totalCost);
    }

    public int getCorpWaterInLitres() {
        return corpWaterInLitres;
    }

    public int getBorewellWaterInLitres() {
        return borewellWaterInLitres;
    }

    public int getTankerWaterInLitres() {
        return tankerWaterInLitres;
    }

    public int getTotalWaterInLitres() {
        return totalWaterInLitres;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
