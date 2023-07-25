package com.example.command;

import com.example.visitor.WaterBillVisitor;

public class BillCommand implements Command {

    @Override
    public void execute(WaterBillVisitor waterBillVisitor) {
        waterBillVisitor.visit(this);
    }
}
