package com.example.command;

import com.example.visitor.WaterBillVisitor;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    private final List<Command> chainOfCommands = new ArrayList<>();

    public void addCommand(Command command) {
        chainOfCommands.add(command);
    }

    public void execute() {
        WaterBillVisitor waterBillVisitor = new WaterBillVisitor();
        for (Command command: chainOfCommands) {
            command.execute(waterBillVisitor);
        }
    }
}
