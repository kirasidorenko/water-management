package com.example.command;

import com.example.visitor.WaterBillVisitor;

@FunctionalInterface
public interface Command {
    void execute(WaterBillVisitor waterBillVisitor);
}
