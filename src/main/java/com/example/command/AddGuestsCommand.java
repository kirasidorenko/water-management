package com.example.command;

import com.example.visitor.WaterBillVisitor;

public class AddGuestsCommand implements Command {

    private int numberOfGuests;

    public AddGuestsCommand(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    @Override
    public void execute(WaterBillVisitor waterBillVisitor) {
        waterBillVisitor.visit(this);
    }
}
